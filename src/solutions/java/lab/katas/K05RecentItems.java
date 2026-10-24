package lab.katas;

import java.util.*;

/** Kata 05: a bounded "recently used" list built on Java 21 sequenced collections. */
public final class K05RecentItems<T> {
    private final int capacity;
    private final LinkedHashSet<T> items = new LinkedHashSet<>();

    public K05RecentItems(int capacity) {
        if (capacity < 1) throw new IllegalArgumentException("capacity must be at least 1");
        this.capacity = capacity;
    }

    public void use(T item) {
        items.addFirst(item);
        while (items.size() > capacity) items.removeLast();
    }

    public Optional<T> newest() { return items.isEmpty() ? Optional.empty() : Optional.of(items.getFirst()); }

    public Optional<T> oldest() { return items.isEmpty() ? Optional.empty() : Optional.of(items.getLast()); }

    public List<T> newestFirst() { return List.copyOf(items); }

    public List<T> oldestFirst() { return List.copyOf(items.reversed()); }
}
