import java.util.Random;
import java.util.Scanner;

public class RockGame {
    public static void main(String[] args) {
        RockGame rockGame = new RockGame();
        rockGame.rockGame();
    }

    private void rockGame(){
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();

        int winner;

        do{
            System.out.print("가위(1) 바위(2) 보(3): ");
            int user = scanner.nextInt();
            userState("사용자", user);
            int com = random.nextInt(3) + 1;
            userState("컴퓨터", com);

            winner = user - com;

            if(winner == 0 ){
                System.out.println("비겼습니다. 다시 합니다.");
            } else if(winner == 1|| winner == -2){
                System.out.println("이겼습니다 !");
            }else{
                System.out.println("졌습니다");
            }
        }
        while(winner == 0);
    }

    private void userState(String user, int state){
        if(state == 1){
            System.out.printf("%s는 가위(1)입니다.%n", user, state);
        }else if(state == 2){
            System.out.printf("%s는 바위(2)입니다.%n", user, state);
        }else if(state ==3){
            System.out.printf("%s는 보(3)입니다.%n", user, state);
        }
    }
}
