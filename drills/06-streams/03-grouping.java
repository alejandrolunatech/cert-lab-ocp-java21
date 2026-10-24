// Drill 06.03 - groupingBy with a downstream collector
// Predict: the output, DOES NOT COMPILE, or EXCEPTION <SimpleName>.
// Then run: java bin/Drill.java 06-streams/03-grouping

import java.util.*;
import java.util.stream.*;

public class Main {
    public static void main(String[] args) {
        var words = List.of("apple", "avocado", "banana", "blueberry", "cherry");
        Map<Character, Long> counts = words.stream()
            .collect(Collectors.groupingBy(w -> w.charAt(0), TreeMap::new, Collectors.counting()));
        Map<Boolean, List<Integer>> parts = Stream.of(1, 2, 3, 4, 5)
            .collect(Collectors.partitioningBy(i -> i > 3));
        System.out.print(counts + " " + parts);
    }
}
