import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class CardGameEx {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        System.out.print("게임 참여자 수 > ");
        int numHands = s.nextInt();
        System.out.print("참여자 당 카드 수 > ");
        int cardsPerHand = s.nextInt();

        List<Card> deck = new ArrayList<Card>();
        for (Card.Suit suit : Card.Suit.values()) {
            for (Card.Rank rank : Card.Rank.values()) {
                deck.add(new Card(suit, rank));
            }
        }
        Collections.shuffle(deck);

        if (numHands * cardsPerHand > deck.size()) {
            System.out.println("Not enough cards.");
            return;
        }
        for (int i = 0; i < numHands; i++)
            System.out.println(dealHand(deck, cardsPerHand));
    }

    public static <E> List<E> dealHand(List<E> deck, int n) {
        int deckSize = deck.size();
        List<E> handView = deck.subList(deckSize - n, deckSize);
        List<E> hand = new ArrayList<E>(handView);
        handView.clear();
        return hand;
    }

    interface Displayable {
        String getDisplay();

    }

    static class Card {
        enum Suit implements Displayable {
            SPADES("♠"), DIAMONDS("♦"), CLUBS("♣"), HEARTS("♥");

            private final String display;

            Suit(String display) {
                this.display = display;
            }


            @Override
            public String getDisplay() {
                return display;
            }
        }

        enum Rank implements Displayable {
            ACE("ACE"), _2("2"), _3("3"), _4("4"), _5("5"),
            _6("6"), _7("7"), _8("8"),
            _9("9"), _10("10"), JACK("JACK"), QUEEN("QUEEN"), KING("KING");
            // 이늄 상수

            private final String display;

            Rank(String display) {
                this.display = display;
            }

            @Override
            public String getDisplay() {
                return display;
            }

        }

        private Suit suit;
        private Rank rank;

        public Card(Card.Suit suit, Card.Rank rank) {
            this.suit = suit;
            this.rank = rank;
        }

        @Override
        public String toString() {
            return "Card{" +
                    "suit=" + suit +
                    ", rank=" + rank +
                    '}';
        }
    }


}