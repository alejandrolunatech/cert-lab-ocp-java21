package lab.katas;

import java.io.IOException;
import java.nio.file.*;
import java.text.MessageFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.*;
import java.util.stream.*;

/** Kata 06: resource bundles, formatting and NIO.2 files. */
public final class K06Receipts {
    private K06Receipts() {}

    public static String greeting(Locale locale, String name, int items) {
        ResourceBundle bundle = ResourceBundle.getBundle("lab.katas.messages", locale, ResourceBundle.Control.getNoFallbackControl(ResourceBundle.Control.FORMAT_PROPERTIES));
        return new MessageFormat(bundle.getString("greeting"), locale).format(new Object[] {name, items});
    }

    public static Path write(Path dir, LocalDate date, List<String> lines) throws IOException {
        Files.createDirectories(dir);
        Path file = dir.resolve("receipt-" + date.format(DateTimeFormatter.BASIC_ISO_DATE) + ".txt");
        return Files.write(file, lines);
    }

    public static long countReceipts(Path dir) throws IOException {
        try (Stream<Path> s = Files.list(dir)) {
            return s.filter(p -> p.getFileName().toString().matches("receipt-\\d{8}\\.txt")).count();
        }
    }
}
