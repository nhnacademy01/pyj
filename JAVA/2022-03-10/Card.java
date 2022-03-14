import java.util.Enumeration;
import java.util.Random;

// spades, hearts, diamonds, clubs
class Suit {
    String display;
    int order;

    public Suit(String display) {
        this.display = display;
    }

    public Suit(String display, int order) {
        this.display = display;
        this.order = order;
    }

    @Override
    public String toString() {
        return display;
    }
}

// Ace, 2, 3, 4, 5, 6, 7, 8, 9, 10, Jack, Queen, King.
class Number {
    int value;

    public Number(int value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return Integer.toString(value);
    }
}

class Card {
    private Suit suit;
    private Number number;

    public Card() {

    }

    public Card(Suit suit, Number number) {
        this.suit = suit;
        this.number = number;
    }

    public static Card joker(int[] playerCard, int i) {
        playerCard[i] = 40;
        return null;
    }

    @Override
    public String toString() {
        return suit.toString()+ number.toString();
    }
}

class CardMain {
    public static void main(String[] args) {
        Random random = new Random();

        Card card = new Card();

        // spades, hearts, diamonds, clubs
        // Ace, 2, 3, 4, 5, 6, 7, 8, 9, 10, Jack, Queen, King.
        String[] suitDisplay = {"♠", "♥", "◈", "♣"};

        Card[][] cardArr = new Card[4][13];
        int[] playerCard = new int[2];
        Card[] playerCardDisplay = new Card[2];

        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 13; j++) {
                Suit suit = new Suit(suitDisplay[i]);
                Number number = new Number(j);
                card = new Card(suit, number);
                cardArr[i][j] = card;
            }
        }

        for (int i = 0; i < playerCard.length; i++) {
            int suit = random.nextInt(4) + 1;
            int number = random.nextInt(13);
            if (suit == 4) {
                card.joker(playerCard, i);
                continue;
            }
            playerCard[i] = (100 * suit) + number;
            playerCardDisplay[i] = cardArr[suit][number];
        }

        // 출력하는곳
        for (int i = 0; i < playerCard.length; i++) {
            if (playerCardDisplay[i] == null) {
                System.out.print("조커 ");
            } else {
                System.out.print(playerCardDisplay[i] + " ");
            }
            System.out.println();

            for (int j = 0; j < i; j++) {
                if (playerCard[i] > playerCard[j]) {
                    System.out.println("유저1의 승리입니다.");
                } else if (playerCard[i] == playerCard[j]) {
                    System.out.println("무승부 입니다.");
                } else {
                    System.out.println("유저2의 승리입니다.");
                }
            }
        }
        System.out.println();
    }
}