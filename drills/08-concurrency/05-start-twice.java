// Drill 08.05 - A thread can be started once
// Predict: the output, DOES NOT COMPILE, or EXCEPTION <SimpleName>.
// Then run: java bin/Drill.java 08-concurrency/05-start-twice

public class Main {
    public static void main(String[] args) throws Exception {
        Thread t = Thread.ofVirtual().unstarted(() -> {});
        t.start();
        t.join();
        t.start();
    }
}
