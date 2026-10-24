package lab.katas;

import java.util.*;

/**
 * Kata 05: a bounded "recently used" list built on Java 21 sequenced collections.
 *
 * <p>{@code use(x)} puts x at the front (moving it if it is already there) and drops the oldest
 * items beyond the capacity. Hint: {@code LinkedHashSet.addFirst} moves an existing element in
 * Java 21; also {@code getFirst}, {@code getLast}, {@code removeLast}, {@code reversed}.
 * The returned lists must be unmodifiable copies.
 *
 * <p>Run: ./mvnw test -Dtest=K05RecentItemsTest
 */
public final class K05RecentItems<T> {

    public K05RecentItems(int capacity) {
        throw new UnsupportedOperationException("TODO kata 05");
    }

    public void use(T item) { throw new UnsupportedOperationException("TODO kata 05"); }

    public Optional<T> newest() { throw new UnsupportedOperationException("TODO kata 05"); }

    public Optional<T> oldest() { throw new UnsupportedOperationException("TODO kata 05"); }

    public List<T> newestFirst() { throw new UnsupportedOperationException("TODO kata 05"); }

    public List<T> oldestFirst() { throw new UnsupportedOperationException("TODO kata 05"); }
}
