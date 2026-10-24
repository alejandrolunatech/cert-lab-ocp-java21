// Drill 04.04 - Catching a checked exception that cannot be thrown
// Predict: the output, DOES NOT COMPILE, or EXCEPTION <SimpleName>.
// Then run: java bin/Drill.java 04-exceptions/04-unreachable-catch

import java.io.IOException;

public class Main {
    public static void main(String[] args) {
        try {
            System.out.print("hi");
        } catch (IOException e) {
            System.out.print("io");
        }
    }
}
