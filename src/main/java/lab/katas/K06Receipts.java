package lab.katas;

import java.io.IOException;
import java.nio.file.*;
import java.time.LocalDate;
import java.util.*;

/**
 * Kata 06: resource bundles, formatting and NIO.2 files.
 *
 * <p>1. {@code greeting}: load bundle {@code lab.katas.messages} (files in src/main/resources/lab/katas)
 *    for the locale, take key {@code greeting} and fill it with MessageFormat. A locale without its
 *    own file (French) must get the base file, never the machine's default locale: use
 *    {@code ResourceBundle.Control.getNoFallbackControl(FORMAT_PROPERTIES)}.
 * <p>2. {@code write}: create the folder if needed and write the lines to
 *    {@code receipt-YYYYMMDD.txt} ({@code DateTimeFormatter.BASIC_ISO_DATE}). Return the path.
 * <p>3. {@code countReceipts}: count files in the folder whose name matches receipt-8digits.txt.
 *    Close the directory stream.
 *
 * <p>Run: ./mvnw test -Dtest=K06ReceiptsTest
 */
public final class K06Receipts {
    private K06Receipts() {}

    public static String greeting(Locale locale, String name, int items) {
        throw new UnsupportedOperationException("TODO kata 06");
    }

    public static Path write(Path dir, LocalDate date, List<String> lines) throws IOException {
        throw new UnsupportedOperationException("TODO kata 06");
    }

    public static long countReceipts(Path dir) throws IOException {
        throw new UnsupportedOperationException("TODO kata 06");
    }
}
