package lab.katas;

import java.util.*;

/**
 * Kata 03: collectors you must write without looking them up. One stream pipeline per method.
 *
 * <p>1. totalByCustomer: cents per customer, sorted by customer (groupingBy with a map factory).
 * <p>2. topCategory: the category with the highest total; ties go to the alphabetically first one;
 *    empty list gives Optional.empty().
 * <p>3. bigOrders: count of orders at or above the threshold (true) and below it (false).
 * <p>4. customersJoined: distinct customers, sorted, as "[ann, bob]".
 *
 * <p>Run: ./mvnw test -Dtest=K03OrderStatsTest
 */
public final class K03OrderStats {
    private K03OrderStats() {}

    public record Order(String customer, String category, int cents) {}

    public static SortedMap<String, Integer> totalByCustomer(List<Order> orders) {
        throw new UnsupportedOperationException("TODO kata 03");
    }

    public static Optional<String> topCategory(List<Order> orders) {
        throw new UnsupportedOperationException("TODO kata 03");
    }

    public static Map<Boolean, Long> bigOrders(List<Order> orders, int thresholdCents) {
        throw new UnsupportedOperationException("TODO kata 03");
    }

    public static String customersJoined(List<Order> orders) {
        throw new UnsupportedOperationException("TODO kata 03");
    }
}
