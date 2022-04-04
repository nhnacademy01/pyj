package day6;

public class ExceptionEx {
    public static void main(String[] args) {
        // 예외잡기
//        exceptionExample();

        // 여러 예외 잡기
        someMethod(new String[]{"nhn", "1"}); // ArrayIndexOutOfBoundsException
        someMethod2(new String[]{"nhn"}); // NumberFormatException
    }

    public static void exceptionExample() {
        int num = 0;
        try {
            num = Integer.parseInt("ABC");  // 예외 발생
        } catch (NumberFormatException cause) {
            num = 0;
            System.out.println("파싱 실패");// 예외가 발생하는 경우 0으로 설정
            System.out.println("cause = "+cause);
        }
        System.out.println("num: " + num);
    }

    static void someMethod(String[] strs) {
        int num = 0;
        try {
            num = Integer.parseInt(strs[2]);
        } catch (ArrayIndexOutOfBoundsException aie) { // 배열에 해당 요소가 없을 때 
            System.out.println("catch ArrayIndexOutOfBoundsException" + aie);
        } catch (NumberFormatException nfe) { // 해당 문자열을 숫자로 변경할 수 없는 경우
            System.out.println("catch NumberFormatException" + nfe);
        }
        System.out.println("num = " + num);
    }

    static void someMethod2(String[] strs) {
        int num = 0;
        try {
            num = Integer.parseInt(strs[0]);
        } catch (ArrayIndexOutOfBoundsException aie) { // 배열에 해당 요소가 없을 때
            System.out.println("catch ArrayIndexOutOfBoundsException" + aie);
        } catch (NumberFormatException nfe) { // 해당 문자열을 숫자로 변경할 수 없는 경우
            System.out.println("catch NumberFormatException" + nfe);
        }
        System.out.println("num = " + num);
    }
}
