package lab.katas;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Objects;

/** Kata 02: a record that validates and normalises in its compact constructor. */
public record K02Money(BigDecimal amount, String currency) implements Comparable<K02Money> {
    public K02Money {
        Objects.requireNonNull(amount, "amount");
        Objects.requireNonNull(currency, "currency");
        if (!currency.matches("[A-Z]{3}")) throw new IllegalArgumentException("currency must be 3 capital letters");
        if (amount.signum() < 0) throw new IllegalArgumentException("amount must not be negative");
        amount = amount.setScale(2, RoundingMode.HALF_EVEN);
    }

    public static K02Money of(String amount, String currency) {
        return new K02Money(new BigDecimal(amount), currency);
    }

    public K02Money plus(K02Money other) {
        if (!currency.equals(other.currency)) throw new IllegalArgumentException("currency mismatch");
        return new K02Money(amount.add(other.amount), currency);
    }

    @Override
    public int compareTo(K02Money other) {
        if (!currency.equals(other.currency)) throw new IllegalArgumentException("currency mismatch");
        return amount.compareTo(other.amount);
    }

    @Override
    public String toString() {
        return amount.toPlainString() + " " + currency;
    }
}
