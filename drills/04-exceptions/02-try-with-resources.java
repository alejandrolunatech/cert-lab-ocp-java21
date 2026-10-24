// Drill 04.02 - Close order and suppressed exceptions
// Predict: the output, DOES NOT COMPILE, or EXCEPTION <SimpleName>.
// Then run: java bin/Drill.java 04-exceptions/02-try-with-resources

public class Main {
    record Res(String name) implements AutoCloseable {
        public void close() {
            System.out.print("close-" + name + " ");
            throw new IllegalStateException(name);
        }
    }
    public static void main(String[] args) {
        try (var a = new Res("a"); var b = new Res("b")) {
            throw new RuntimeException("body");
        } catch (Exception e) {
            System.out.print(e.getMessage() + " " + e.getSuppressed().length);
        }
    }
}
