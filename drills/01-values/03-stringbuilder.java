// Drill 01.03 - StringBuilder is mutable
// Predict: the output, DOES NOT COMPILE, or EXCEPTION <SimpleName>.
// Then run: java bin/Drill.java 01-values/03-stringbuilder

public class Main {
    public static void main(String[] args) {
        var sb = new StringBuilder("abc");
        sb.append("de").insert(1, "-").reverse();
        String s = "abc";
        s.concat("de").toUpperCase();
        System.out.print(sb + " " + s);
    }
}
