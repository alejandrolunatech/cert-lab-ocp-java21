// Drill 05.03 - Sequenced collections (Java 21)
// Predict: the output, DOES NOT COMPILE, or EXCEPTION <SimpleName>.
// Then run: java bin/Drill.java 05-collections/03-sequenced

import java.util.*;

public class Main {
    public static void main(String[] args) {
        SequencedCollection<Integer> list = new ArrayList<>(List.of(1, 2, 3));
        list.addFirst(0);
        list.addLast(4);
        LinkedHashMap<String, Integer> map = new LinkedHashMap<>();
        map.put("x", 1); map.put("y", 2);
        map.putFirst("w", 0);
        System.out.print(list.reversed() + " " + list.getFirst() + " " + map.firstEntry() + " " + map.sequencedKeySet().reversed());
    }
}
