package lab.katas;

import java.math.BigDecimal;

/**
 * Kata 02: a record that validates and normalises in its compact constructor.
 *
 * <p>1. Compact constructor: reject null, a currency that is not 3 capital letters, and a negative
 *    amount (IllegalArgumentException); store the amount with scale 2, HALF_EVEN rounding.
 * <p>2. {@code plus}: same currency only, otherwise IllegalArgumentException.
 * <p>3. Natural order by amount within one currency; toString "12.50 EUR".
 *
 * <p>Run: ./mvnw test -Dtest=K02MoneyTest
 */
public record K02Money(BigDecimal amount, String currency) implements Comparable<K02Money> {

    public static K02Money of(String amount, String currency) {
        return new K02Money(new BigDecimal(amount), currency);
    }

    public K02Money plus(K02Money other) {
        throw new UnsupportedOperationException("TODO kata 02");
    }

    @Override
    public int compareTo(K02Money other) {
        throw new UnsupportedOperationException("TODO kata 02");
    }
}
