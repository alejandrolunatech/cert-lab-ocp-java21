// Drill 10.01 - NumberFormat by locale
// Predict: the output, DOES NOT COMPILE, or EXCEPTION <SimpleName>.
// Then run: java bin/Drill.java 10-localization/01-number-format

import java.text.*;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        double v = 1234567.891;
        System.out.print(NumberFormat.getInstance(Locale.GERMANY).format(v) + " | "
            + NumberFormat.getInstance(Locale.US).format(v) + " | "
            + NumberFormat.getCompactNumberInstance(Locale.US, NumberFormat.Style.SHORT).format(v));
    }
}
