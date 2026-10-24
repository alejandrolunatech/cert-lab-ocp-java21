// Drill 04.05 - A failed cast inside try
// Predict: the output, DOES NOT COMPILE, or EXCEPTION <SimpleName>.
// Then run: java bin/Drill.java 04-exceptions/05-cast-in-try

public class Main {
    public static void main(String[] args) {
        try {
            Object o = "text";
            Integer i = (Integer) o;
        } catch (RuntimeException e) {
            System.out.print("runtime ");
        } finally {
            System.out.print("done");
        }
    }
}
