// Drill 06.05 - reduce with identity
// Predict: the output, DOES NOT COMPILE, or EXCEPTION <SimpleName>.
// Then run: java bin/Drill.java 06-streams/05-reduce

import java.util.stream.*;

public class Main {
    public static void main(String[] args) {
        int sum = IntStream.rangeClosed(1, 4).reduce(10, Integer::sum);
        var max = Stream.<Integer>empty().reduce(Integer::max);
        System.out.print(sum + " " + max + " " + IntStream.range(1, 4).average().getAsDouble());
    }
}
