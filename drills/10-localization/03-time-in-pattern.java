// Drill 10.03 - Formatting a LocalDate with a time pattern
// Predict: the output, DOES NOT COMPILE, or EXCEPTION <SimpleName>.
// Then run: java bin/Drill.java 10-localization/03-time-in-pattern

import java.time.*;
import java.time.format.*;

public class Main {
    public static void main(String[] args) {
        System.out.print(LocalDate.of(2026, 1, 1).format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm")));
    }
}
