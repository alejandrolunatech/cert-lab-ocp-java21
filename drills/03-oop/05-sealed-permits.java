// Drill 03.05 - Sealed subclasses must choose
// Predict: the output, DOES NOT COMPILE, or EXCEPTION <SimpleName>.
// Then run: java bin/Drill.java 03-oop/05-sealed-permits

public class Main {
    sealed interface Vehicle permits Car, Bike {}
    final class Car implements Vehicle {}
    class Bike implements Vehicle {}
    public static void main(String[] args) {
        System.out.print("ok");
    }
}
