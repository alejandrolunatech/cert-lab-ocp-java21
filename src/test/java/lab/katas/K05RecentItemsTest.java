package lab.katas;

import static org.junit.jupiter.api.Assertions.*;

import java.util.*;
import org.junit.jupiter.api.Test;

class K05RecentItemsTest {
    @Test
    void keepsMostRecentFirstAndDropsOldest() {
        var r = new K05RecentItems<String>(3);
        for (var s : List.of("a", "b", "c", "a", "d")) r.use(s);
        assertEquals(List.of("d", "a", "c"), r.newestFirst());
        assertEquals(List.of("c", "a", "d"), r.oldestFirst());
        assertEquals(Optional.of("d"), r.newest());
        assertEquals(Optional.of("c"), r.oldest());
    }

    @Test
    void emptyAndValidation() {
        var r = new K05RecentItems<Integer>(1);
        assertEquals(Optional.empty(), r.newest());
        assertThrows(IllegalArgumentException.class, () -> new K05RecentItems<Integer>(0));
    }

    @Test
    void returnedListsAreUnmodifiable() {
        var r = new K05RecentItems<String>(2);
        r.use("x");
        assertThrows(UnsupportedOperationException.class, () -> r.newestFirst().add("y"));
    }
}
