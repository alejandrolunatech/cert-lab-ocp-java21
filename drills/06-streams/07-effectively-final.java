// Drill 06.07 - Lambdas capture effectively final variables
// Predict: the output, DOES NOT COMPILE, or EXCEPTION <SimpleName>.
// Then run: java bin/Drill.java 06-streams/07-effectively-final

import java.util.*;

public class Main {
    public static void main(String[] args) {
        int total = 0;
        List.of(1, 2, 3).forEach(i -> total += i);
        System.out.print(total);
    }
}
