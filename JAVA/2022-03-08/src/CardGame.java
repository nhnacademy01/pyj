import java.util.Random;

public class CardGame {
    public static void main(String[] args) {
        CardGame cardGame = new CardGame();
        cardGame.cardGame();
    }

    private void cardGame() {
        //무작위로 카드를 2장을 뽑아서 숫자가 큰 사람이 이김.
        // 단 조커를 뽑으면 그 사람이 무조건 이김
        //
        //배열로 카드를 만들어서 사용해보기
        //가로: 하트 < 스페이스 < 클로버 < 다이아몬드
        //세로: A < 2~10 < J < Q < K
        //조커 2개가 존재.
        //무승부가 있을 수 있음(ex: 둘 다 조커)

        Random random = new Random();

        String[] row = {"하트", "스페이스", "클로버", "다이아몬드", ""}; // 가로
        String[] column = {"A", "2", "3", "4", "5", "6", "7", "8", "9", "10", "J", "Q", "K"}; // 세로

        String[][] card = new String[row.length][column.length];

        // 카드 생성
        for (int i = 0; i < card.length; i++) {
            for (int j = 0; j < card[i].length; j++) {
                card[i][j] = row[i] + column[j];
            }
        }

        int[] userCard = new int[2];
        String[] userCardDetail = new String[2];

        // 유저 각 1장씩 뽑기
        for (int i = 0; i < userCard.length; i++) {
            int rowRandom = random.nextInt(row.length);
            int colRandom = random.nextInt(column.length);

            userCard[i] = (rowRandom * 100) + colRandom;
            if (rowRandom == 4) {
                userCardDetail[i] = "조커";
            } else {
                userCardDetail[i] = card[rowRandom][colRandom];
            }
        }

        for (int i = 0; i < userCard.length; i++) {
            System.out.println("유저" + (i + 1) + " : " + userCardDetail[i]);
        }
        System.out.println();


        if (userCard[0] / 100 > userCard[1] / 100) {
            System.out.println("유저 1의 승리입니다.");
        } else if (userCard[0] / 100 == userCard[1] / 100) {
            if (userCard[0] % 100 > userCard[1] % 100) {
                System.out.println("유저 1의 승리입니다.");
            } else if (userCard[0] % 100 == userCard[1] % 100) {
                System.out.println("비겼습니다.");
            } else {
                System.out.println("유저 2의 승리입니다.");
            }
        } else {
            System.out.println("유저 2의 승리입니다.");
        }

    }
}
