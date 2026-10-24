// Drill 08.04 - run() is not start()
// Predict: the output, DOES NOT COMPILE, or EXCEPTION <SimpleName>.
// Then run: java bin/Drill.java 08-concurrency/04-run-vs-start

public class Main {
    public static void main(String[] args) throws Exception {
        Thread t = new Thread(() -> System.out.print(Thread.currentThread().getName() + " "));
        t.setName("worker");
        t.run();
        t.start();
        t.join();
    }
}
