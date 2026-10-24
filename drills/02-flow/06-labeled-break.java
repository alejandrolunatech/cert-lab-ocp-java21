// Drill 02.06 - Labelled loops
// Predict: the output, DOES NOT COMPILE, or EXCEPTION <SimpleName>.
// Then run: java bin/Drill.java 02-flow/06-labeled-break

public class Main {
    public static void main(String[] args) {
        int count = 0;
        outer:
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (j == 2) continue outer;
                if (i == 2) break outer;
                count++;
            }
        }
        System.out.print(count);
    }
}
