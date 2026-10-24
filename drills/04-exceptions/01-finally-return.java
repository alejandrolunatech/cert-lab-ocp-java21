// Drill 04.01 - finally overrides return
// Predict: the output, DOES NOT COMPILE, or EXCEPTION <SimpleName>.
// Then run: java bin/Drill.java 04-exceptions/01-finally-return

public class Main {
    static int f() {
        try {
            return 1;
        } finally {
            System.out.print("finally ");
        }
    }
    static int g() {
        try { throw new RuntimeException(); }
        catch (RuntimeException e) { return 2; }
        finally { return 3; }
    }
    public static void main(String[] args) {
        System.out.print(f() + " " + g());
    }
}
