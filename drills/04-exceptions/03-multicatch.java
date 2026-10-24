// Drill 04.03 - Multi-catch with related types
// Predict: the output, DOES NOT COMPILE, or EXCEPTION <SimpleName>.
// Then run: java bin/Drill.java 04-exceptions/03-multicatch

import java.io.*;

public class Main {
    public static void main(String[] args) {
        try {
            throw new FileNotFoundException();
        } catch (FileNotFoundException | IOException e) {
            System.out.print("caught");
        }
    }
}
