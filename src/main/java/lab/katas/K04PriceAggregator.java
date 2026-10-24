package lab.katas;

import java.time.Duration;
import java.util.*;

/**
 * Kata 04: fan out blocking calls on virtual threads and keep the best answer in time.
 *
 * <p>Call every source at the same time, one virtual thread each
 * ({@code Executors.newVirtualThreadPerTaskExecutor()} in try-with-resources).
 * Return the lowest quote among the sources that answered within the timeout.
 * Ignore sources that throw or are too slow. No answer at all gives OptionalInt.empty().
 *
 * <p>Useful: {@code invokeAll(tasks, timeout, unit)}, {@code Future.state()}, {@code resultNow()} (Java 19+).
 *
 * <p>Run: ./mvnw test -Dtest=K04PriceAggregatorTest
 */
public final class K04PriceAggregator {
    private K04PriceAggregator() {}

    @FunctionalInterface
    public interface PriceSource {
        int quote() throws Exception;
    }

    public static OptionalInt cheapest(List<PriceSource> sources, Duration timeout) throws InterruptedException {
        throw new UnsupportedOperationException("TODO kata 04");
    }
}
