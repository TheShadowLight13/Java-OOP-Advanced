package pr08.models;

import pr08.enums.CardRanks;
import pr08.enums.CardSuits;

public class Card{

    private CardRanks cardRank;
    private CardSuits cardSuit;

    public Card(CardRanks cardRank, CardSuits cardSuit) {
        this.cardRank = cardRank;
        this.cardSuit = cardSuit;
    }

    public CardRanks getCardRank() {
        return this.cardRank;
    }

    public CardSuits getCardSuit() {
        return this.cardSuit;
    }

    public int getCardPower() {
        return (this.cardRank.getRankPower() + this.cardSuit.getSuitPower());
    }

    @Override
    public boolean equals(Object obj) {
        Card card = (Card)obj;
        return this.getCardRank().name().equals(card.getCardRank().name())
                && this.getCardSuit().name().equals(card.getCardSuit().name());
    }

    @Override
    public int hashCode() {
        return this.getCardRank().hashCode() + this.getCardSuit().hashCode();
    }
}
