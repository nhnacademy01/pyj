package game;

import java.util.Scanner;

public class TEST {
    public static void main(String[] args) {
        String clientAnswer = getClientAnswer();
        int i = 1;
        while(clientAnswer.equals("1")){
            switch (i){
                case 1:
                    System.out.println("hji");
                    clientAnswer = getClientAnswer();
                    if(!clientAnswer.equals("1")){
                        break;
                    }else{
                        System.out.println("sdfad");
                    }
                default:
                    System.out.println("무야호");
            }
            System.out.println();

        }
        // 초
    }

    private static String getClientAnswer() {
        Scanner scanner = new Scanner(System.in);

        return scanner.nextLine();
    }
}
