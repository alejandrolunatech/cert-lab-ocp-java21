// Drill 02.05 - Guards with when
// Predict: the output, DOES NOT COMPILE, or EXCEPTION <SimpleName>.
// Then run: java bin/Drill.java 02-flow/05-guarded-pattern

public class Main {
    sealed interface Shape permits Circle, Square {}
    record Circle(double r) implements Shape {}
    record Square(double side) implements Shape {}

    static String describe(Shape s) {
        return switch (s) {
            case Circle c when c.r() > 10 -> "big circle";
            case Circle c -> "circle";
            case Square(double side) when side == 0 -> "dot";
            case Square sq -> "square";
        };
    }
    public static void main(String[] args) {
        System.out.print(describe(new Circle(11)) + ", " + describe(new Circle(1)) + ", " + describe(new Square(0)));
    }
}
