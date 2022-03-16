import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class CardGame {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("게임 참여자 수 > ");
        int numHands = scanner.nextInt();
        System.out.print("참여자 당 카드 수 > ");
        int cardsPerHand = scanner.nextInt();

        /**
         * 리팩토링 포인트
         * 1. Card라는 클래스를 따로 만들어서 하기
         * 2. 메소드 분리 (인자 받는 것 ,,
         * 3. 예외처리
         */

        String[] suit = new String[] {"♠", "♥", "♦", "♣"};
        String[] rank = new String[] {
                "Ace", "2", "3", "4",
                "5", "6", "7", "8", "9", "10",
                "Jack", "Queen", "King" };

        List<String> deck = new ArrayList<String>(); //업캐스팅해서 받았음
        for (int i = 0; i < suit.length; i++) {
            for (int j = 0; j < rank.length; j++) {
                deck.add(suit[i] + " " + rank[j]);
            }
        }

        Collections.shuffle(deck); // 목록을 섞어주는 메소드

        /**
         * 이거 메소드 분리 isEnoughCards..
         */
        if(numHands * cardsPerHand > deck.size()){
            System.out.println("Not enough cards");
            return;
        }

        for (int i = 0; i < numHands; i++) {
            System.out.println(dealHand(deck, cardsPerHand));
            // 사람수만큼 돌려서
            // 한사람당 하나씩 카드를 주는 것
        }
    }

    public static <E> List<E> dealHand(List<E> deck, int n){
        int deckSize = deck.size();
        List<E> handView = deck.subList(deckSize - n, deckSize);
        // 맨 첫사람부터 n 장씩 쭉쭉 주는 메소드
        List<E> hand = new ArrayList<E>(handView);
        handView.clear();
        return hand;
    }
}
