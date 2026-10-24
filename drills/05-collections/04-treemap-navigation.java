// Drill 05.04 - TreeMap navigation
// Predict: the output, DOES NOT COMPILE, or EXCEPTION <SimpleName>.
// Then run: java bin/Drill.java 05-collections/04-treemap-navigation

import java.util.*;

public class Main {
    public static void main(String[] args) {
        TreeMap<Integer, String> m = new TreeMap<>(Map.of(10, "a", 20, "b", 30, "c"));
        System.out.print(m.floorKey(25) + " " + m.ceilingKey(25) + " " + m.headMap(20) + " " + m.tailMap(20, true).keySet());
    }
}
