// Drill 09.02 - Files read and write
// Predict: the output, DOES NOT COMPILE, or EXCEPTION <SimpleName>.
// Then run: java bin/Drill.java 09-io/02-files-roundtrip

import java.nio.file.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        Path tmp = Files.createTempFile("drill", ".txt");
        Files.write(tmp, List.of("one", "two"));
        Files.writeString(tmp, "three\n", StandardOpenOption.APPEND);
        try (var lines = Files.lines(tmp)) {
            System.out.print(lines.filter(l -> l.contains("o")).count() + " " + Files.readAllLines(tmp).size());
        }
        Files.delete(tmp);
    }
}
