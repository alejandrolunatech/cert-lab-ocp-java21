// Drill 03.01 - Initialization order
// Predict: the output, DOES NOT COMPILE, or EXCEPTION <SimpleName>.
// Then run: java bin/Drill.java 03-oop/01-init-order

public class Main {
    static class Base {
        static { System.out.print("Bs "); }
        { System.out.print("Bi "); }
        Base() { System.out.print("Bc "); }
    }
    static class Child extends Base {
        static { System.out.print("Cs "); }
        { System.out.print("Ci "); }
        Child() { System.out.print("Cc "); }
    }
    public static void main(String[] args) {
        new Child();
        new Child();
    }
}
