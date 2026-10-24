// Drill 01.07 - Wrapper caching
// Predict: the output, DOES NOT COMPILE, or EXCEPTION <SimpleName>.
// Then run: java bin/Drill.java 01-values/07-integer-cache

public class Main {
    public static void main(String[] args) {
        Integer a = 127, b = 127, c = 128, d = 128;
        System.out.print((a == b) + " " + (c == d) + " " + c.equals(d));
    }
}
