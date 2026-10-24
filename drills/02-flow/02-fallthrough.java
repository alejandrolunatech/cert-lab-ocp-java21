// Drill 02.02 - Old switch falls through
// Predict: the output, DOES NOT COMPILE, or EXCEPTION <SimpleName>.
// Then run: java bin/Drill.java 02-flow/02-fallthrough

public class Main {
    public static void main(String[] args) {
        int x = 1;
        StringBuilder sb = new StringBuilder();
        switch (x) {
            case 1: sb.append("one ");
            case 2: sb.append("two ");
                break;
            default: sb.append("other");
        }
        System.out.print(sb.toString().trim());
    }
}
