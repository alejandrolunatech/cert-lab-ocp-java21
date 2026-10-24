// Drill 08.02 - Lost updates
// Predict: the output, DOES NOT COMPILE, or EXCEPTION <SimpleName>.
// Then run: java bin/Drill.java 08-concurrency/02-atomic-vs-plain

import java.util.concurrent.*;
import java.util.concurrent.atomic.*;

public class Main {
    public static void main(String[] args) throws Exception {
        AtomicInteger atomic = new AtomicInteger();
        try (var exec = Executors.newFixedThreadPool(4)) {
            for (int i = 0; i < 1000; i++) exec.submit(atomic::incrementAndGet);
        }
        System.out.print(atomic.get());
    }
}
