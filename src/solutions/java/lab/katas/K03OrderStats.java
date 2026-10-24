package lab.katas;

import java.util.*;
import java.util.stream.*;

/** Kata 03: collectors you must write without looking them up. */
public final class K03OrderStats {
    private K03OrderStats() {}

    public record Order(String customer, String category, int cents) {}

    public static SortedMap<String, Integer> totalByCustomer(List<Order> orders) {
        return orders.stream().collect(Collectors.groupingBy(Order::customer, TreeMap::new, Collectors.summingInt(Order::cents)));
    }

    public static Optional<String> topCategory(List<Order> orders) {
        return orders.stream()
            .collect(Collectors.groupingBy(Order::category, Collectors.summingInt(Order::cents)))
            .entrySet().stream()
            .max(Map.Entry.<String, Integer>comparingByValue().thenComparing(Map.Entry.comparingByKey(Comparator.reverseOrder())))
            .map(Map.Entry::getKey);
    }

    public static Map<Boolean, Long> bigOrders(List<Order> orders, int thresholdCents) {
        return orders.stream().collect(Collectors.partitioningBy(o -> o.cents() >= thresholdCents, Collectors.counting()));
    }

    public static String customersJoined(List<Order> orders) {
        return orders.stream().map(Order::customer).distinct().sorted().collect(Collectors.joining(", ", "[", "]"));
    }
}
