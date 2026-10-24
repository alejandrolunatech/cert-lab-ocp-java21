package lab.katas;

import static org.junit.jupiter.api.Assertions.*;

import java.nio.file.*;
import java.time.LocalDate;
import java.util.*;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.io.TempDir;

class K06ReceiptsTest {
    @Test
    void greetsInTheLocaleWithChoiceFormat() {
        assertEquals("Hola Ana, tienes un producto", K06Receipts.greeting(Locale.of("es", "ES"), "Ana", 1));
        assertEquals("Hallo Bram, je hebt 1.200 artikelen", K06Receipts.greeting(Locale.of("nl", "NL"), "Bram", 1200));
        assertEquals("Hello Cy, you have no items", K06Receipts.greeting(Locale.US, "Cy", 0));
    }

    @Test
    void unknownLocaleFallsBackToTheBaseBundle() {
        Locale before = Locale.getDefault();
        try {
            Locale.setDefault(Locale.of("es"));
            assertEquals("Hello Zoé, you have 2 items", K06Receipts.greeting(Locale.FRANCE, "Zoé", 2));
        } finally {
            Locale.setDefault(before);
        }
    }

    @Test
    void writesAndCountsReceipts(@TempDir Path tmp) throws Exception {
        Path dir = tmp.resolve("out");
        Path f = K06Receipts.write(dir, LocalDate.of(2026, 12, 11), List.of("coffee 2.50", "cake 3.10"));
        assertEquals("receipt-20261211.txt", f.getFileName().toString());
        assertEquals(List.of("coffee 2.50", "cake 3.10"), Files.readAllLines(f));
        K06Receipts.write(dir, LocalDate.of(2026, 12, 12), List.of("tea 2.00"));
        Files.writeString(dir.resolve("notes.txt"), "not a receipt");
        assertEquals(2, K06Receipts.countReceipts(dir));
    }
}
