// Drill 08.03 - CompletableFuture composition
// Predict: the output, DOES NOT COMPILE, or EXCEPTION <SimpleName>.
// Then run: java bin/Drill.java 08-concurrency/03-completablefuture

import java.util.concurrent.*;

public class Main {
    public static void main(String[] args) {
        var price = CompletableFuture.supplyAsync(() -> 100);
        var rate = CompletableFuture.supplyAsync(() -> 2);
        String r = price.thenCombine(rate, (p, x) -> p * x)
            .thenApply(v -> "total=" + v)
            .exceptionally(e -> "failed")
            .join();
        String f = CompletableFuture.supplyAsync(() -> { throw new IllegalStateException(); })
            .handle((v, e) -> e == null ? "ok" : e.getCause().getClass().getSimpleName())
            .join();
        System.out.print(r + " " + f);
    }
}
