// Drill 07.01 - What a single-file program knows about modules
// Predict: the output, DOES NOT COMPILE, or EXCEPTION <SimpleName>.
// Then run: java bin/Drill.java 07-modules/01-describe

public class Main {
    public static void main(String[] args) {
        Module m = Main.class.getModule();
        System.out.print(m.isNamed() + " " + String.class.getModule().getName());
    }
}
