package day6;

public class Equals {
    public static void main(String[] args) {
        Str s1 = new Str("10");
        Str s2 = new Str("10");

        System.out.println("1. s1 equals s2?: " + s1.equals(s2));
        System.out.println("2. s1 = s2");
        s1 = s2;
        System.out.println("3. s1 equals s2?: " + s1.equals(s2));
    }
}
class Str {
    String value;
    public Str(String value) {
        this.value = value;
    }
}