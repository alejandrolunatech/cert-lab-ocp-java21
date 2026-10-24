// Drill 06.06 - flatMap and Optional
// Predict: the output, DOES NOT COMPILE, or EXCEPTION <SimpleName>.
// Then run: java bin/Drill.java 06-streams/06-flatmap-optional

import java.util.*;

public class Main {
    static Optional<String> lookup(int id) { return id == 1 ? Optional.of("ann") : Optional.empty(); }
    public static void main(String[] args) {
        String a = Optional.of(1).flatMap(Main::lookup).map(String::toUpperCase).orElse("none");
        String b = Optional.of(2).flatMap(Main::lookup).map(String::toUpperCase).orElse("none");
        System.out.print(a + " " + b + " " + Optional.ofNullable(null).isPresent());
    }
}
