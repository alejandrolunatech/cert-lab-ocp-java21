// Drill 03.03 - Records cannot have instance fields
// Predict: the output, DOES NOT COMPILE, or EXCEPTION <SimpleName>.
// Then run: java bin/Drill.java 03-oop/03-record-field

public class Main {
    record Point(int x, int y) {
        private int cachedHash;
    }
    public static void main(String[] args) {
        System.out.print(new Point(1, 2));
    }
}
