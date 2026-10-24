// Drill 05.07 - Mutating an element inside a HashSet
// Predict: the output, DOES NOT COMPILE, or EXCEPTION <SimpleName>.
// Then run: java bin/Drill.java 05-collections/07-hashset-mutable-key

import java.util.*;

public class Main {
    public static void main(String[] args) {
        List<String> key = new ArrayList<>(List.of("a"));
        Set<List<String>> set = new HashSet<>();
        set.add(key);
        key.add("b");
        System.out.print(set.contains(key) + " " + set.size());
    }
}
