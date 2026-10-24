// Drill 01.05 - LocalDate is immutable
// Predict: the output, DOES NOT COMPILE, or EXCEPTION <SimpleName>.
// Then run: java bin/Drill.java 01-values/05-local-date

import java.time.*;

public class Main {
    public static void main(String[] args) {
        LocalDate d = LocalDate.of(2024, 1, 31);
        d.plusDays(1);
        LocalDate e = d.plusMonths(1);
        System.out.print(d + " " + e + " " + e.isLeapYear());
    }
}
