// Drill 02.07 - instanceof pattern scope
// Predict: the output, DOES NOT COMPILE, or EXCEPTION <SimpleName>.
// Then run: java bin/Drill.java 02-flow/07-instanceof-pattern

public class Main {
    public static void main(String[] args) {
        Object o = "hello";
        if (!(o instanceof String s)) {
            return;
        }
        System.out.print(s.length());
    }
}
