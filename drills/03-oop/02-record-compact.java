// Drill 03.02 - Record compact constructor
// Predict: the output, DOES NOT COMPILE, or EXCEPTION <SimpleName>.
// Then run: java bin/Drill.java 03-oop/02-record-compact

public class Main {
    record Range(int lo, int hi) {
        Range {
            if (lo > hi) { int t = lo; lo = hi; hi = t; }
        }
    }
    public static void main(String[] args) {
        System.out.print(new Range(5, 2) + " " + new Range(1, 2).equals(new Range(1, 2)));
    }
}
