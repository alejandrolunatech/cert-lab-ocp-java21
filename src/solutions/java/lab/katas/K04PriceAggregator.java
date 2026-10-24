package lab.katas;

import java.time.Duration;
import java.util.*;
import java.util.concurrent.*;

/** Kata 04: fan out blocking calls on virtual threads and keep the best answer in time. */
public final class K04PriceAggregator {
    private K04PriceAggregator() {}

    @FunctionalInterface
    public interface PriceSource {
        int quote() throws Exception;
    }

    public static OptionalInt cheapest(List<PriceSource> sources, Duration timeout) throws InterruptedException {
        try (ExecutorService exec = Executors.newVirtualThreadPerTaskExecutor()) {
            List<Callable<Integer>> calls = sources.stream().<Callable<Integer>>map(s -> s::quote).toList();
            List<Future<Integer>> futures = exec.invokeAll(calls, timeout.toMillis(), TimeUnit.MILLISECONDS);
            OptionalInt best = OptionalInt.empty();
            for (Future<Integer> f : futures) {
                if (f.state() == Future.State.SUCCESS) {
                    int v = f.resultNow();
                    if (best.isEmpty() || v < best.getAsInt()) best = OptionalInt.of(v);
                }
            }
            return best;
        }
    }
}
