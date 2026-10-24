// Drill 09.03 - resolve with an absolute path
// Predict: the output, DOES NOT COMPILE, or EXCEPTION <SimpleName>.
// Then run: java bin/Drill.java 09-io/03-resolve

import java.nio.file.*;

public class Main {
    public static void main(String[] args) {
        Path a = Path.of("/data");
        System.out.print(a.resolve("logs/app.log") + " " + a.resolve("/etc/hosts") + " " + Path.of("logs").resolveSibling("tmp"));
    }
}
