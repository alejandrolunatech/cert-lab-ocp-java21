package lab.katas;

import static org.junit.jupiter.api.Assertions.*;

import java.util.*;
import lab.katas.K03OrderStats.Order;
import org.junit.jupiter.api.Test;

class K03OrderStatsTest {
    static final List<Order> ORDERS = List.of(
        new Order("bob", "books", 1500),
        new Order("ann", "games", 4000),
        new Order("bob", "games", 1000),
        new Order("cy", "books", 3500),
        new Order("ann", "music", 200));

    @Test
    void totalsPerCustomerSorted() {
        var totals = K03OrderStats.totalByCustomer(ORDERS);
        assertEquals(List.of("ann", "bob", "cy"), new ArrayList<>(totals.keySet()));
        assertEquals(4200, totals.get("ann"));
    }

    @Test
    void topCategoryBreaksTiesAlphabetically() {
        assertEquals(Optional.of("books"), K03OrderStats.topCategory(ORDERS), "books 5000 ties games 5000; books wins");
        assertEquals(Optional.empty(), K03OrderStats.topCategory(List.of()));
    }

    @Test
    void partitionsByThreshold() {
        assertEquals(Map.of(true, 2L, false, 3L), K03OrderStats.bigOrders(ORDERS, 3500));
    }

    @Test
    void joinsDistinctSortedCustomers() {
        assertEquals("[ann, bob, cy]", K03OrderStats.customersJoined(ORDERS));
    }
}
