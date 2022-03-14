package day6;

public class StringEquals {
    public static void main(String[] args) {
        String s1 = "nhn-academy";
        String s2 = "nhn-academy";
        String ns1 = new String("nhn-academy");
        String ns2 = new String("nhn-academy");

        System.out.println("s1 == s2: " + (s1 == s2)); //f
        // s1과 s2가 동일한 객체를 갖냐 = 같은 메모리 주소를 가지냐?
        // 리터럴 방식으로 만들면 여러번 생성하더라도 메모리가 같구낭
        System.out.println("s1 == ns1: " + (s1 == ns1)); //f
        // 메모리 주소가 달라서
        System.out.println("ns1 == ns2: " + (ns1 == ns2)); //f
        System.out.println("s1.equals(s2): " + s1.equals(s2)); //t
        System.out.println("s1.equals(ns1): " + s1.equals(ns1)); //t
        System.out.println("ns1.equals(ns2): " + ns1.equals(ns2)); //t
    }
}
