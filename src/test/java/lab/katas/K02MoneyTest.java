package lab.katas;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;
import java.util.TreeSet;
import org.junit.jupiter.api.Test;

class K02MoneyTest {
    @Test
    void normalisesScaleSoEqualAmountsAreEqual() {
        assertEquals(K02Money.of("12.5", "EUR"), K02Money.of("12.50", "EUR"));
        assertEquals("12.50 EUR", K02Money.of("12.5", "EUR").toString());
        assertEquals("0.12 EUR", K02Money.of("0.125", "EUR").toString(), "HALF_EVEN rounds 0.125 down to 0.12");
    }

    @Test
    void rejectsBadInput() {
        assertThrows(IllegalArgumentException.class, () -> K02Money.of("-1", "EUR"));
        assertThrows(IllegalArgumentException.class, () -> K02Money.of("1", "eur"));
        assertThrows(NullPointerException.class, () -> new K02Money(null, "EUR"));
    }

    @Test
    void addsOnlySameCurrency() {
        assertEquals(K02Money.of("3.00", "EUR"), K02Money.of("1", "EUR").plus(K02Money.of("2", "EUR")));
        assertThrows(IllegalArgumentException.class, () -> K02Money.of("1", "EUR").plus(K02Money.of("1", "USD")));
    }

    @Test
    void sortsByAmount() {
        var set = new TreeSet<>(List.of(K02Money.of("5", "EUR"), K02Money.of("1", "EUR"), K02Money.of("3", "EUR")));
        assertEquals("1.00 EUR", set.first().toString());
    }
}
