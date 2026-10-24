// Drill 03.04 - Fields are not polymorphic
// Predict: the output, DOES NOT COMPILE, or EXCEPTION <SimpleName>.
// Then run: java bin/Drill.java 03-oop/04-polymorphism-fields

public class Main {
    static class A { String name = "A"; String who() { return "A"; } }
    static class B extends A { String name = "B"; @Override String who() { return "B"; } }
    public static void main(String[] args) {
        A ref = new B();
        System.out.print(ref.name + " " + ref.who() + " " + ((B) ref).name);
    }
}
