import java.util.Scanner;

public class Calculator {
    public static void main(String[] args) {
        Calculator calculator = new Calculator();
        calculator.calculator();
    }

    private void calculator(){
        Scanner scanner = new Scanner(System.in);

        System.out.println("어떤 연산을 하실건가요? (+, -, *, /) ");
        String sign = scanner.nextLine();

        System.out.println("피연산자 두 개의 수를 입력하세요.");
        int firstNum = scanner.nextInt();
        int secNum = scanner.nextInt();
        int result = 0;

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
        }
        System.out.printf("%s %s %s = %s 입니다.", firstNum,sign,secNum, result);
    }
}
