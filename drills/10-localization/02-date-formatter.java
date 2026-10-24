// Drill 10.02 - DateTimeFormatter patterns
// Predict: the output, DOES NOT COMPILE, or EXCEPTION <SimpleName>.
// Then run: java bin/Drill.java 10-localization/02-date-formatter

import java.time.*;
import java.time.format.*;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        LocalDateTime t = LocalDateTime.of(2026, 12, 11, 9, 5);
        System.out.print(t.format(DateTimeFormatter.ofPattern("dd MMM yyyy HH:mm", Locale.US)) + " | "
            + t.format(DateTimeFormatter.ofPattern("EEEE d MMMM", Locale.of("es", "ES"))) + " | "
            + t.format(DateTimeFormatter.ISO_LOCAL_DATE));
    }
}
