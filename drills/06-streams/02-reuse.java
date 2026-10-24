// Drill 06.02 - A stream can be used once
// Predict: the output, DOES NOT COMPILE, or EXCEPTION <SimpleName>.
// Then run: java bin/Drill.java 06-streams/02-reuse

import java.util.stream.*;

public class Main {
    public static void main(String[] args) {
        Stream<String> s = Stream.of("a", "b");
        s.forEach(x -> {});
        System.out.print(s.count());
    }
}
