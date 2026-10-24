// Drill 05.02 - Arrays.asList is a fixed-size view
// Predict: the output, DOES NOT COMPILE, or EXCEPTION <SimpleName>.
// Then run: java bin/Drill.java 05-collections/02-arrays-aslist

import java.util.*;

public class Main {
    public static void main(String[] args) {
        String[] arr = {"a", "b", "c"};
        List<String> view = Arrays.asList(arr);
        view.set(0, "z");
        arr[2] = "y";
        System.out.print(view + " " + Arrays.toString(arr));
    }
}
