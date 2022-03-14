public class StringComparator {
    public static void main(String[] args) {
        String name = "hong";
        String newName = new String("hong");

        // 동등성과 동일성의 차이 구분해야한다
        // 레퍼런스 타입에 대한 동등성 비교는 equals 사용

        // 참조형을 == 으로 비교하면 같은 메모리 주소인지 여부를 비교한다
        // 객체를 비교할 때는 equals()로 비교해야한다

        // 문자열 , 문자열 비교시 true
        // == 일 때 true는 동일한 객체 (주소값이 같다)
        // 문자열의 리터럴 타입은 특정 문자열 풀에 있다 (선언하는 순간 특정 문자열 풀에 있다가 뽑아 쓰는 것)
        // 3번째줄 new를 썻다는 것은 새로운 메모리에 할당을 한 것
        // 4번째줄 false
        // 5번째줄 equals는 문자열! 을 비교하는거임

        System.out.printf("\"hong\" == \"hong\" ?\t %b%n", "hong"=="hong");
        System.out.printf("\"hong\" == name ? \t %b%n", "hong" == name);
        System.out.printf("\"hong\" == newName ?\t %b%n", "hong" == newName);
        System.out.printf("name == newName ?\t %b%n", name == newName);
        System.out.printf("\"hong\".equals(name) ? \t\t %b%n", "hong".equals(name));
        System.out.printf("\"hong\".equals(newName) ? \t %b%n", "hong".equals(newName));
        System.out.printf("name.equals(newName) ?\t\t %b%n", name.equals(newName));
    }
}
