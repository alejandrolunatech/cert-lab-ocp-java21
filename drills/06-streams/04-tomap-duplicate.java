// Drill 06.04 - toMap with duplicate keys
// Predict: the output, DOES NOT COMPILE, or EXCEPTION <SimpleName>.
// Then run: java bin/Drill.java 06-streams/04-tomap-duplicate

import java.util.*;
import java.util.stream.*;

public class Main {
    public static void main(String[] args) {
        Map<Integer, String> byLength = Stream.of("aa", "bb", "c")
            .collect(Collectors.toMap(String::length, s -> s));
        System.out.print(byLength);
    }
}
