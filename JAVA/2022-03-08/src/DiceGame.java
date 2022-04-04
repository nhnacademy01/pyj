import jdk.swing.interop.SwingInterOpUtils;

import java.util.Random;
import java.util.Scanner;

public class DiceGame {
    public static void main(String[] args) {
        DiceGame diceGame = new DiceGame();

        // 솔루션
        System.out.println("----솔루션----");
        diceGame.diceGame();

        // 응용까지 포함된 솔루션
        System.out.println("----응용 포함된 솔루션----");
        diceGame.advancedDiceGame();

    }

    private void diceGame() {
        Random random = new Random();

        System.out.println("첫번째 주사위 게임을 시작합니다.");
        int userA = random.nextInt(6) + 1;
        int userB = random.nextInt(6) + 1;

        System.out.println("유저 A : " + userA + " / 유저 B : " + userB);
        if (userA > userB) {
            System.out.println("유저 A 승리");
        } else if (userA == userB) {
            System.out.println("유저 A, B 무승부");
        } else {
            System.out.println("유저 B 승리");
        }
    }

    private void advancedDiceGame() {
        Random random = new Random();
        Scanner scanner = new Scanner(System.in);

        System.out.println("두번째 주사위 게임을 시작합니다.");
        System.out.println("참가자의 숫자를 입력하세요 ");
        int userNum = scanner.nextInt();

        System.out.println("주사위 갯수를 설정하세요 (2개 초과)");
        int diceNum = scanner.nextInt();

        int[][] userDice = new int[diceNum][userNum];
        int[] userDiceSum = new int[userNum];


        // 주사위 숫자 생성
        for (int i = 0; i < userNum; i++) {
            for (int j = 0; j < diceNum; j++) {
                userDice[j][i] = random.nextInt(6) + 1;
            }

            // 주사위 합 저장
            for (int j = 0; j < diceNum; j++) {
                userDiceSum[i] += userDice[j][i];
            }

            // 중복이면 다시 뽑아
            for (int j = 0; j < i; j++) {
                if (userDiceSum[i] == userDiceSum[j]) {
                    System.out.println("주사위 숫자를 다시 생성합니다");
                    i = j;
                    break;
                }
            }
        }

//        // 주사위 상태 프린트
//        for (int i = 0; i < diceNum; i++) {
//            for (int j = 0; j < userNum; j++) {
//                System.out.print(userDice[i][j] + " ");
//            }
//            System.out.println();
//        }//삭제 가능

        // 유저의 주사위 합 출력
        for (int i = 0; i < userDiceSum.length; i++) {
            System.out.printf("유저 %d번 주사위 합: %d%n", (i + 1), userDiceSum[i]);
        }

        // 우승자 가려내기기
        int max = 0;
        int winnerNum = 0;
        for (int i = 0; i < userDiceSum.length; i++) {
            if (max < userDiceSum[i]) {
                max = userDiceSum[i];
                winnerNum = i;
            }
        }
        System.out.printf("사용자 %d번이 주사위 합 %d로 우승했습니다.", (winnerNum + 1), max);


    }
}

