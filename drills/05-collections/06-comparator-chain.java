// Drill 05.06 - Comparator chains
// Predict: the output, DOES NOT COMPILE, or EXCEPTION <SimpleName>.
// Then run: java bin/Drill.java 05-collections/06-comparator-chain

import java.util.*;

public class Main {
    record P(String name, int age) {}
    public static void main(String[] args) {
        List<P> ps = new ArrayList<>(List.of(new P("bo", 30), new P("al", 30), new P("cy", 25)));
        ps.sort(Comparator.comparingInt(P::age).reversed().thenComparing(P::name));
        System.out.print(ps.stream().map(P::name).toList());
    }
}
