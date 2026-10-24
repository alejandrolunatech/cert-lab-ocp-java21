// Drill 06.01 - Streams are lazy
// Predict: the output, DOES NOT COMPILE, or EXCEPTION <SimpleName>.
// Then run: java bin/Drill.java 06-streams/01-lazy

import java.util.stream.*;

public class Main {
    public static void main(String[] args) {
        Stream<Integer> s = Stream.of(1, 2, 3, 4).peek(i -> System.out.print("p" + i + " ")).filter(i -> i % 2 == 0);
        System.out.print("start ");
        System.out.print(s.findFirst().get());
    }
}
