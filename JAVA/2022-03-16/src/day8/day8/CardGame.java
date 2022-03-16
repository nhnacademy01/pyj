package day8;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class CardGame {
    public static void main(String[] args) {
        CardGameInput input = getCardGameInput();

        List<Card> deck = getShuffledCards();

        checkInput(input, deck);

        dealHand(input, deck);
    }

    private static void checkInput(CardGameInput input, List<Card> deck) {
        if (isEnoughCard(input, deck)) {
            throw new IllegalArgumentException("입력 받은 게임 참여자 수와 카드 수가 너무 큽니다.");
        }
    }

    private static CardGameInput getCardGameInput() {
        Scanner s = new Scanner(System.in);
        System.out.print("게임 참여자 수 > ");
        int numHands = s.nextInt();
        System.out.print("참여자 당 카드 수 > ");
        int cardsPerHand = s.nextInt();
        CardGameInput input = new CardGameInput(numHands, cardsPerHand);
        return input;
    }

    private static void dealHand(CardGameInput input, List<Card> deck) {
        for (int i = 0; i < input.getNumHands(); i++)
            System.out.println(dealHand(deck, input.getCardsPerHand()));
    }

    private static boolean isEnoughCard(CardGameInput input, List<Card> deck) {
        return input.getNumHands() * input.getCardsPerHand() > deck.size();
    }

    private static List<Card> getShuffledCards() {
        String[] suits = new String[]{"♠", "♥", "♦", "♣"};
        String[] ranks = new String[]{
                "Ace", "2", "3", "4",
                "5", "6", "7", "8", "9", "10",
                "Jack", "Queen", "King"};
        List<Card> deck = new ArrayList<>();
        for (String suit : suits) {
            for (String rank : ranks) {
                deck.add(new Card(suit, rank));
            }
        }
        Collections.shuffle(deck);
        return deck;
    }

    public static <E> List<E> dealHand(List<E> deck, int cardsPerHand) {
        int deckSize = deck.size();
        List<E> handView = deck.subList(deckSize - cardsPerHand, deckSize);
        List<E> hand = new ArrayList<>(handView);
        handView.clear();
        return hand;
    }
}

class Card {
    String suit;
    String rank;

    public Card(String suit, String rank) {
        this.suit = suit;
        this.rank = rank;
    }

    public String getSuit() {
        return suit;
    }

    public String getRank() {
        return rank;
    }

    @Override
    public String toString() {
        return suit + " " + rank;
    }
}

class CardGameInput {
    private final int numHands;
    private final int cardsPerHand;

    public CardGameInput(int numHands, int cardsPerHand) {
        this.numHands = numHands;
        this.cardsPerHand = cardsPerHand;
    }

    public int getNumHands() {
        return numHands;
    }

    public int getCardsPerHand() {
        return cardsPerHand;
    }
}














