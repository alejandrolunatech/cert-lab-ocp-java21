package lab.katas;

import static org.junit.jupiter.api.Assertions.*;

import java.time.Duration;
import java.util.*;
import java.util.stream.*;
import lab.katas.K04PriceAggregator.PriceSource;
import org.junit.jupiter.api.Test;

class K04PriceAggregatorTest {
    static PriceSource after(int millis, int price) {
        return () -> { Thread.sleep(millis); return price; };
    }

    @Test
    void picksCheapestOfThoseOnTime() throws Exception {
        var sources = List.of(after(50, 120), after(80, 99), after(2_000, 10), () -> { throw new IllegalStateException("down"); });
        assertEquals(OptionalInt.of(99), K04PriceAggregator.cheapest(sources, Duration.ofMillis(500)));
    }

    @Test
    void runsConcurrently() throws Exception {
        var sources = IntStream.range(0, 200).mapToObj(i -> after(200, 1000 - i)).toList();
        long start = System.nanoTime();
        var best = K04PriceAggregator.cheapest(sources, Duration.ofSeconds(5));
        long millis = (System.nanoTime() - start) / 1_000_000;
        assertEquals(OptionalInt.of(801), best);
        assertTrue(millis < 2_000, "200 calls of 200 ms each must run in parallel, took " + millis + " ms");
    }

    @Test
    void emptyWhenNobodyAnswers() throws Exception {
        assertEquals(OptionalInt.empty(), K04PriceAggregator.cheapest(List.of(after(1_000, 5)), Duration.ofMillis(100)));
    }
}
