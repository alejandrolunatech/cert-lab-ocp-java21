// Drill 03.06 - Enum with constant bodies
// Predict: the output, DOES NOT COMPILE, or EXCEPTION <SimpleName>.
// Then run: java bin/Drill.java 03-oop/06-enum-methods

public class Main {
    enum Op {
        ADD { int apply(int a, int b) { return a + b; } },
        MUL { int apply(int a, int b) { return a * b; } };
        abstract int apply(int a, int b);
    }
    public static void main(String[] args) {
        System.out.print(Op.valueOf("MUL").apply(3, 4) + " " + Op.ADD.ordinal() + " " + Op.values().length);
    }
}
