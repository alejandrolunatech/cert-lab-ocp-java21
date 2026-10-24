// Drill 01.01 - Integer overflow and casts
// Predict: the output, DOES NOT COMPILE, or EXCEPTION <SimpleName>.
// Then run: java bin/Drill.java 01-values/01-int-overflow

public class Main {
    public static void main(String[] args) {
        int big = Integer.MAX_VALUE;
        long a = big + 1;
        long b = big + 1L;
        byte c = (byte) 200;
        System.out.print(a + " " + b + " " + c);
    }
}
