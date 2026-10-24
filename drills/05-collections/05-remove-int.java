// Drill 05.05 - remove(int) vs remove(Object)
// Predict: the output, DOES NOT COMPILE, or EXCEPTION <SimpleName>.
// Then run: java bin/Drill.java 05-collections/05-remove-int

import java.util.*;

public class Main {
    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>(List.of(10, 20, 30, 1));
        list.remove(1);
        list.remove(Integer.valueOf(1));
        System.out.print(list);
    }
}
