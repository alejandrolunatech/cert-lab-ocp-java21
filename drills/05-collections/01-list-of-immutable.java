// Drill 05.01 - List.of is unmodifiable
// Predict: the output, DOES NOT COMPILE, or EXCEPTION <SimpleName>.
// Then run: java bin/Drill.java 05-collections/01-list-of-immutable

import java.util.*;

public class Main {
    public static void main(String[] args) {
        List<String> list = List.of("a", "b");
        list.set(0, "z");
        System.out.print(list);
    }
}
