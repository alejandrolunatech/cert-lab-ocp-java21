package lab.katas;

/** Kata 01: sealed hierarchy, records and an exhaustive pattern switch. */
public final class K01Shapes {
    private K01Shapes() {}

    public sealed interface Shape permits Circle, Rect, Triangle {}
    public record Circle(double radius) implements Shape {}
    public record Rect(double width, double height) implements Shape {}
    public record Triangle(double base, double height) implements Shape {}

    public static double area(Shape shape) {
        return switch (shape) {
            case Circle(double r) -> Math.PI * r * r;
            case Rect(double w, double h) -> w * h;
            case Triangle(double b, double h) -> b * h / 2;
        };
    }

    public static String describe(Shape shape) {
        return switch (shape) {
            case Rect(double w, double h) when w == h -> "square " + w;
            case Rect r -> "rectangle " + r.width() + "x" + r.height();
            case Circle c -> "circle r=" + c.radius();
            case Triangle t -> "triangle";
        };
    }
}
