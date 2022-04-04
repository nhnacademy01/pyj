import java.util.Scanner;

public class HomeWork3{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

        HomeWork3 home = new HomeWork3();
        System.out.println("cm으로 변경할 inch를 입력하세요.");
        int inch = sc.nextInt();
        home.InchToCm(inch);

        System.out.println("inch로 변경할 cm를 입력하세요.");
        int cm = sc.nextInt();
        home.CmToInch(cm);
    }

    public void InchToCm(int inch){
        System.out.printf("%d inch는 %.2f cm입니다.%n", inch, inch * 2.54f);
    }

    public void CmToInch(int cm){
        System.out.printf("%d cm는 %.2f inch입니다.%n", cm, cm / 2.54f);
    }
}