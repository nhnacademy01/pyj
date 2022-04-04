public class HashCode {
    public static void main(String[] args) {
        String s1 = "nhn-academy";
        String s2 = "nhn-academy";
        String ns1 = new String("nhn-academy");
        // s1, s2, ns1 은 모두 동등한 객체이다
        // 동등하니까 hashCode 값이 같다 (hashCode 값이 같다고 동등하지는 않다 (왜냐면 해시충돌이 있다))
        // 동일성은 확신할 수 없다
        String2 s21 = new String2("nhn-academy");
        String2 s22 = new String2("nhn-academy");

        System.out.println("s1.hashCode(): " + s1.hashCode());
        System.out.println("s2.hashCode(): " + s2.hashCode());
        System.out.println("ns1.hashCode(): " + ns1.hashCode());
        System.out.println("s21.hashCode(): " + s21.hashCode());
        System.out.println("s22.hashCode(): " + s22.hashCode());
        // s21, s22 는 hashCodㅗe 메소드를 재정의하지 않았기 때문에 다르다

        System.out.println("s1 == s2: " + (s1 == s2));
        System.out.println("s1 == ns1: " + (s1 == ns1));
        System.out.println("s1.equals(s2): " + s1.equals(s2));
        System.out.println("s1.equals(ns1): " + s1.equals(ns1));
        System.out.println("s21 == s22: " + (s21 == s22));
        System.out.println("s21.equals(s22): " + s21.equals(s22));
        // equals 연산자를 재정의 하지 않았기 때문에 false가 나온다
    }
}
class String2 {
    String value;
    public String2(String value) {
        this.value = value;
    }
}