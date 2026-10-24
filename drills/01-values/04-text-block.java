// Drill 01.04 - Text block whitespace
// Predict: the output, DOES NOT COMPILE, or EXCEPTION <SimpleName>.
// Then run: java bin/Drill.java 01-values/04-text-block

public class Main {
    public static void main(String[] args) {
        String t = """
            a
              b\
            c
            """;
        System.out.print(t.replace("\n", "|"));
    }
}
