package pr02;

import pr02.enums.CardRanks;
import pr02.enums.CardSuits;

public class Card implements Comparable<Card>{

    private CardRanks cardRank;
    private CardSuits cardSuit;

    public Card(CardRanks cardRank, CardSuits cardSuit) {
        this.cardRank = cardRank;
        this.cardSuit = cardSuit;
    }

    public int getCardPower() {
        return this.cardRank.getPower() + this.cardSuit.getPower();
    }

    @Override
    public String toString() {
        return String.format("Card name: %s of %s; Card power: %d",
                this.cardRank.name(),
                this.cardSuit.name(),
                this.getCardPower());
    }

    @Override
    public int compareTo(Card other) {
        return Integer.compare(this.getCardPower(), other.getCardPower());
    }
}
