// Drill 01.02 - String identity
// Predict: the output, DOES NOT COMPILE, or EXCEPTION <SimpleName>.
// Then run: java bin/Drill.java 01-values/02-string-pool

public class Main {
    public static void main(String[] args) {
        String a = "java";
        String b = "ja" + "va";
        String part = "ja";
        String c = part + "va";
        System.out.print((a == b) + " " + (a == c) + " " + (a == c.intern()));
    }
}
