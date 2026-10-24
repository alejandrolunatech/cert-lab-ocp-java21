// Drill 02.01 - Switch expression with yield
// Predict: the output, DOES NOT COMPILE, or EXCEPTION <SimpleName>.
// Then run: java bin/Drill.java 02-flow/01-switch-expression

public class Main {
    static String size(int n) {
        return switch (n) {
            case 0 -> "none";
            case 1, 2 -> "few";
            default -> {
                if (n < 0) yield "invalid";
                yield "many";
            }
        };
    }
    public static void main(String[] args) {
        System.out.print(size(2) + " " + size(-1) + " " + size(9));
    }
}
