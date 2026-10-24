package lab.katas;

/**
 * Kata 01: sealed hierarchy, records and an exhaustive pattern switch.
 *
 * <p>1. Make {@code Shape} a sealed interface that permits exactly Circle, Rect and Triangle.
 * <p>2. {@code area}: one switch expression with record patterns and no default branch.
 * <p>3. {@code describe}: "square 2.0" when a Rect has equal sides (use a {@code when} guard),
 *    "rectangle 2.0x3.0", "circle r=1.0" and "triangle" otherwise.
 *
 * <p>Run: ./mvnw test -Dtest=K01ShapesTest
 */
public final class K01Shapes {
    private K01Shapes() {}

    public interface Shape {}
    public record Circle(double radius) implements Shape {}
    public record Rect(double width, double height) implements Shape {}
    public record Triangle(double base, double height) implements Shape {}

    public static double area(Shape shape) {
        throw new UnsupportedOperationException("TODO kata 01");
    }

    public static String describe(Shape shape) {
        throw new UnsupportedOperationException("TODO kata 01");
    }
}
