// Drill 01.06 - Period vs Duration
// Predict: the output, DOES NOT COMPILE, or EXCEPTION <SimpleName>.
// Then run: java bin/Drill.java 01-values/06-duration-period

import java.time.*;

public class Main {
    public static void main(String[] args) {
        System.out.print(Period.of(1, 14, 0) + " " + Period.of(1, 14, 0).normalized() + " " + Duration.ofMinutes(90));
    }
}
