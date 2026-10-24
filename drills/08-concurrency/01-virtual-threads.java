// Drill 08.01 - Virtual threads
// Predict: the output, DOES NOT COMPILE, or EXCEPTION <SimpleName>.
// Then run: java bin/Drill.java 08-concurrency/01-virtual-threads

import java.util.concurrent.*;
import java.util.stream.*;

public class Main {
    public static void main(String[] args) throws Exception {
        try (var exec = Executors.newVirtualThreadPerTaskExecutor()) {
            var futures = IntStream.range(0, 1000)
                .mapToObj(i -> exec.submit(() -> { Thread.sleep(10); return i; }))
                .toList();
            long sum = 0;
            for (var f : futures) sum += f.get();
            System.out.print(sum + " " + Thread.currentThread().isVirtual());
        }
    }
}
