// Drill 02.03 - Dominated pattern labels
// Predict: the output, DOES NOT COMPILE, or EXCEPTION <SimpleName>.
// Then run: java bin/Drill.java 02-flow/03-pattern-switch-order

public class Main {
    static String kind(Object o) {
        return switch (o) {
            case CharSequence cs -> "chars";
            case String s -> "string";
            default -> "other";
        };
    }
    public static void main(String[] args) {
        System.out.print(kind("hi"));
    }
}
