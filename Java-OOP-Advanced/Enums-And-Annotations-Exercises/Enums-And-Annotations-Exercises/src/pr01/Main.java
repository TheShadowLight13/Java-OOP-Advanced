package pr01;

import pr01.enums.CardRanks;

public class Main {

    public static void main(String[] args) {
        CardRanks[] cardRanks = CardRanks.values();

        System.out.println("Card Ranks:");

        for (CardRanks cardRank : cardRanks) {
            System.out.println(cardRank);
        }
    }
}
