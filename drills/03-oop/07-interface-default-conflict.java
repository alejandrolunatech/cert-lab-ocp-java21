// Drill 03.07 - Two defaults with the same signature
// Predict: the output, DOES NOT COMPILE, or EXCEPTION <SimpleName>.
// Then run: java bin/Drill.java 03-oop/07-interface-default-conflict

public class Main {
    interface Walker { default String move() { return "walk"; } }
    interface Swimmer { default String move() { return "swim"; } }
    static class Duck implements Walker, Swimmer {
        public String move() { return Walker.super.move() + "+" + Swimmer.super.move(); }
    }
    public static void main(String[] args) {
        System.out.print(new Duck().move());
    }
}
