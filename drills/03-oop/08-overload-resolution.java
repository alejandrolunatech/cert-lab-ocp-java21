// Drill 03.08 - Overload resolution order
// Predict: the output, DOES NOT COMPILE, or EXCEPTION <SimpleName>.
// Then run: java bin/Drill.java 03-oop/08-overload-resolution

public class Main {
    static String f(long x) { return "long"; }
    static String f(Integer x) { return "Integer"; }
    static String f(int... x) { return "varargs"; }
    public static void main(String[] args) {
        System.out.print(f(1));
    }
}
