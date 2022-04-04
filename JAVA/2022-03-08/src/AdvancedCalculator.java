import java.util.Scanner;

public class AdvancedCalculator {
    public static void main(String[] args) {
        AdvancedCalculator advancedCalculator = new AdvancedCalculator();
        advancedCalculator.advancedCalculator();

    }

    private void advancedCalculator(){
        Scanner scanner = new Scanner(System.in);
        String sign;
        int result;
        do{
            System.out.println("어떤 연산을 하실건가요? (+, -, *, /) ");
            sign = scanner.next();

            System.out.println("피연산자 두 개의 수를 입력하세요.");

            int firstNum = scanner.nextInt();
            int secNum = scanner.nextInt();

            result = switchCase(sign, 0, firstNum, secNum);

            while(true){
                System.out.println("어떤 연산을 하실건가요? (+, -, *, /) ");
                sign = scanner.next();

                System.out.println("수를 입력하세요.");
                int thirdNum = scanner.nextInt();

                result = switchCase(sign, result, result, thirdNum);
            }
        }while(!sign.equals("quit"));
    }

    private int switchCase(String sign, int result, int firstNum, int secNum){
        switch (sign){
            case "+":
                result = firstNum + secNum;
                break;

            case "-":
                result = firstNum - secNum;
                break;

            case "*":
                result = firstNum * secNum;
                break;

            case "/":
                result = firstNum / secNum;
                break;

            default:
                System.out.println("잘못된 부호입니다");
        }
        System.out.printf("%s %s %s = %s 입니다.%n", firstNum,sign,secNum, result);

        return result;
    }
}
