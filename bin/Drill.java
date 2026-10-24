import java.io.IOException;
import java.nio.file.*;
import java.time.LocalDate;
import java.util.*;
import java.util.concurrent.TimeUnit;
import java.util.regex.*;
import java.util.stream.*;

/**
 * Predict-then-run trainer for the drills/ folder. Needs only a JDK 21: no Maven, no build.
 *
 *   java bin/Drill.java                 list topics and your score per topic
 *   java bin/Drill.java 03-oop          go through the drills of one topic you haven't passed
 *   java bin/Drill.java random 10       ten random drills from every topic
 *   java bin/Drill.java drills/03-oop/01-init-order    one drill
 *   java bin/Drill.java verify          run every drill and compare with drills/answers.tsv (CI)
 *
 * Answers are one line: the output with lines joined by a space, DOES NOT COMPILE,
 * or EXCEPTION SimpleName (printed output first, if any, then the exception).
 */
public class Drill {
    static final Path DRILLS = Path.of("drills");
    static final Path PROGRESS = Path.of(".progress", "drills.tsv");

    public static void main(String[] args) throws Exception {
        if (!Files.isDirectory(DRILLS)) {
            System.err.println("Run this from the repo root: java bin/Drill.java");
            System.exit(2);
        }
        String cmd = args.length == 0 ? "" : args[0];
        switch (cmd) {
            case "" -> overview();
            case "verify" -> System.exit(verify());
            case "random" -> train(shuffle(allDrills()).stream().limit(args.length > 1 ? Integer.parseInt(args[1]) : 10).toList());
            default -> {
                String key = cmd.replaceFirst("^drills/", "").replaceFirst("\\.java$", "");
                if (Files.exists(DRILLS.resolve(key + ".java"))) train(List.of(key));
                else {
                    var passed = progress().keySet();
                    var todo = allDrills().stream().filter(d -> d.startsWith(key + "/") && !passed.contains(d)).toList();
                    if (todo.isEmpty()) System.out.println("Nothing left in '" + key + "'. Try: java bin/Drill.java random 10");
                    train(todo);
                }
            }
        }
    }

    static List<String> allDrills() throws IOException {
        try (var s = Files.walk(DRILLS)) {
            return s.filter(p -> p.toString().endsWith(".java"))
                    .map(p -> DRILLS.relativize(p).toString().replace('\\', '/').replaceFirst("\\.java$", ""))
                    .sorted().toList();
        }
    }

    static Map<String, String> tsv(Path file) throws IOException {
        Map<String, String> m = new LinkedHashMap<>();
        if (!Files.exists(file)) return m;
        for (String line : Files.readAllLines(file)) {
            int tab = line.indexOf('\t');
            if (tab > 0) m.put(line.substring(0, tab), line.substring(tab + 1));
        }
        return m;
    }

    static Map<String, String> progress() throws IOException { return tsv(PROGRESS); }

    static void overview() throws IOException {
        var passed = progress();
        var byTopic = allDrills().stream().collect(Collectors.groupingBy(d -> d.substring(0, d.indexOf('/')), TreeMap::new, Collectors.toList()));
        System.out.println("Topic                 passed");
        byTopic.forEach((t, ds) -> {
            long ok = ds.stream().filter(passed::containsKey).count();
            System.out.printf("%-20s %3d / %d%n", t, ok, ds.size());
        });
        System.out.println("\nStart with: java bin/Drill.java 01-values");
    }

    static void train(List<String> drills) throws Exception {
        var answers = tsv(DRILLS.resolve("answers.tsv"));
        var why = tsv(DRILLS.resolve("explanations.tsv"));
        var in = new Scanner(System.in);
        int right = 0, done = 0;
        for (String d : drills) {
            System.out.println("\n" + "=".repeat(72));
            List<String> src = Files.readAllLines(DRILLS.resolve(d + ".java"));
            for (int i = 0; i < src.size(); i++) System.out.printf("%3d  %s%n", i + 1, src.get(i));
            System.out.print("\nYour prediction (blank to skip, q to stop): ");
            if (!in.hasNextLine()) break;
            String guess = in.nextLine().trim();
            if (guess.equalsIgnoreCase("q")) break;
            if (guess.isEmpty()) continue;
            String actual = run(DRILLS.resolve(d + ".java"));
            boolean ok = norm(guess).equals(norm(actual));
            done++;
            if (ok) right++;
            System.out.println((ok ? "RIGHT  " : "WRONG  ") + "actual: " + actual);
            if (!actual.equals(answers.get(d))) System.out.println("(note: answers.tsv says '" + answers.get(d) + "')");
            System.out.println("Why: " + why.getOrDefault(d, "-"));
            if (ok) record(d);
        }
        if (done > 0) System.out.printf("%n%d of %d right.%n", right, done);
    }

    static void record(String d) throws IOException {
        Files.createDirectories(PROGRESS.getParent());
        Files.writeString(PROGRESS, d + "\t" + LocalDate.now() + "\n", StandardOpenOption.CREATE, StandardOpenOption.APPEND);
    }

    static String norm(String s) {
        return s.trim().replaceAll("\\s+", " ").toLowerCase(Locale.ROOT);
    }

    static final Pattern EXC = Pattern.compile("Exception in thread \"main\" ([\\w.$]+)");

    /** Runs one drill with the source-file launcher of the same JDK and turns the result into one answer line. */
    static String run(Path file) throws Exception {
        String java = ProcessHandle.current().info().command().orElse("java");
        Process p = new ProcessBuilder(java, "-Duser.language=en", "-Duser.country=US", file.toString()).start();
        if (!p.waitFor(60, TimeUnit.SECONDS)) { p.destroyForcibly(); return "TIMEOUT"; }
        String out = new String(p.getInputStream().readAllBytes()).trim().replaceAll("\\s*\\R\\s*", " ");
        String err = new String(p.getErrorStream().readAllBytes());
        if (err.contains("error: compilation failed")) return "DOES NOT COMPILE";
        Matcher m = EXC.matcher(err);
        if (m.find()) {
            String name = m.group(1).substring(m.group(1).lastIndexOf('.') + 1);
            return (out.isEmpty() ? "" : out + " ") + "EXCEPTION " + name;
        }
        return out;
    }

    static int verify() throws Exception {
        var answers = tsv(DRILLS.resolve("answers.tsv"));
        var why = tsv(DRILLS.resolve("explanations.tsv"));
        int bad = 0;
        for (String d : allDrills()) {
            String actual = run(DRILLS.resolve(d + ".java"));
            String expected = answers.get(d);
            boolean ok = actual.equals(expected) && why.containsKey(d);
            if (!ok) bad++;
            System.out.println((ok ? "ok    " : "FAIL  ") + d + (ok ? "" : "  expected '" + expected + "' got '" + actual + "'" + (why.containsKey(d) ? "" : " (no explanation)")));
        }
        System.out.println(bad == 0 ? "All drills match their answers." : bad + " drill(s) do not match.");
        return bad == 0 ? 0 : 1;
    }

    static <T> List<T> shuffle(List<T> list) {
        var copy = new ArrayList<>(list);
        Collections.shuffle(copy);
        return copy;
    }
}
