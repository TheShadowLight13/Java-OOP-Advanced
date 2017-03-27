package pr07;

import pr07.enums.CardRanks;
import pr07.enums.CardSuits;

public class Main {

    public static void main(String[] args) {
        CardRanks[] cardRanks =  CardRanks.values();
        CardSuits[] cardSuits = CardSuits.values();

        for (CardSuits suit : cardSuits) {
            for (CardRanks rank : cardRanks) {
                System.out.printf("%s of %s%n", rank.name(), suit.name());
            }
        }
    }
}
