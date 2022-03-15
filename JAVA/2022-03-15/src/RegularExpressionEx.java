import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegularExpressionEx {

    public static void main(String[] args) {
//        regularExpression1();
//        regularExpression2();
//        regexp3();
        regexp4();
    }

    static void regularExpression1() {
        Pattern p = Pattern.compile("^c.*");    // 'c'로 시작하는 문자열
        Matcher m = p.matcher("car");
        if (m.matches()) {
            System.out.println("Starts with 'c'");
        } else {
            System.out.println("Not starts with 'c'");
        }
    }

    static void regularExpression2() {
        Pattern p = Pattern.compile("([a-zA-Z0-9_.+-]+)@([a-zA-Z0-9-]+\\.[a-zA-Z0-9-.]+)");
        // 그룹1           // 그룹2
        Matcher m = p.matcher("이메일은 hong@nhn.com 입니다.");
        while (m.find()) {
            System.out.println("m.groupCount(): " + m.groupCount());
            System.out.println("m.group(): " + m.group());  // m.group(0)
            System.out.println("m.group(1): " + m.group(1));
            System.out.println("m.group(2): " + m.group(2));
        }
    }

    private static void regexp3() {
        Pattern p = Pattern.compile("([a-zA-Z0-9_.+-]+)@([a-zA-Z0-9-]+\\.[a-zA-Z0-9-.]+)");
        Matcher m = p.matcher("이메일은 hong@nhn.com 입니다.");
        StringBuffer result = new StringBuffer();
        while (m.find()) {
            String localPart = m.group(1);
            m.appendReplacement(result, localPart + "@nhnacademy.com");
            System.out.println("locatPark : " + localPart);
            System.out.println("Result :" + result);
        }
        System.out.println("Result : " + result);
        System.out.println("m : " + m);
        m.appendTail(result);
        System.out.println(result);
    }

    private static void regexp4() {

        String[] callNumbers = new String[]{
                "032-0032-0320",
                "032-0031-0311",
                "031-031-0310",
                "031-031-0322"
        };

        Pattern p = Pattern.compile("([0-9]+)(-[0-9]+\\-.[0-9]+)");
        for (int i = 0; i < callNumbers.length; i++) {
            Matcher m = p.matcher(callNumbers[i]);
            StringBuilder result = new StringBuilder();

            while (m.find()) {
                String localNumber = m.group(1);
                String numbers = m.group(2);
                if (localNumber.equals("032")) {
                    localNumber = "031";
                }
                m.appendReplacement(result, localNumber+numbers);
            }
            System.out.println(result);

        }
    }
}
