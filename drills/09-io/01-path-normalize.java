// Drill 09.01 - Path operations
// Predict: the output, DOES NOT COMPILE, or EXCEPTION <SimpleName>.
// Then run: java bin/Drill.java 09-io/01-path-normalize

import java.nio.file.*;

public class Main {
    public static void main(String[] args) {
        Path p = Path.of("/home/al/./docs/../notes/today.txt");
        Path base = Path.of("/home/al");
        System.out.print(p.normalize() + " " + p.getFileName() + " " + base.relativize(p.normalize()) + " " + p.getNameCount());
    }
}
