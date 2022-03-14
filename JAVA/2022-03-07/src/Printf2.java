public class Printf2 {
    public static void main(String[] args) {
        String url = "nhnacademy.com";

        float f = 10.1f;
        double d = 1.23456789d;

        System.out.println("[1234567890]");
        System.out.printf("[%s]%n", url);
        System.out.printf("[%20s]%n", url);
        System.out.printf("[%-20s]%n", url); //왼쪽 정렬
        System.out.printf("[%.8s]%n", url); // 왼쪽에서 8글자만 출력

        System.out.printf("f = $f, %e, %g%n", f, f, f);
        System.out.printf("d = %f%n", d); // 마지막 자리 반올림

        System.out.printf("d = %15.10f%n", d); // 전체(소수점 포함) 15자리 중 소수점 이하 10자리
    }
}
