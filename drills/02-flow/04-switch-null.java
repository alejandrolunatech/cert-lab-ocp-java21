// Drill 02.04 - Switch on null
// Predict: the output, DOES NOT COMPILE, or EXCEPTION <SimpleName>.
// Then run: java bin/Drill.java 02-flow/04-switch-null

public class Main {
    static String test(String s) {
        return switch (s) {
            case null -> "null";
            case "a" -> "A";
            default -> "other";
        };
    }
    public static void main(String[] args) {
        System.out.print(test(null) + " " + test("a"));
    }
}
