package P04WorkingWithAbstraction_Exercise.P03CardsWithPower;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String card = scanner.nextLine();
        String suit = scanner.nextLine();

        CardRank cardRank = CardRank.valueOf(card);
        CardSuit cardSuit = CardSuit.valueOf(suit);
        int result = cardRank.getPower() + cardSuit.getPower();

        System.out.printf("Card name: %s of %s; Card power: %d", cardRank, cardSuit, result);
    }
}
