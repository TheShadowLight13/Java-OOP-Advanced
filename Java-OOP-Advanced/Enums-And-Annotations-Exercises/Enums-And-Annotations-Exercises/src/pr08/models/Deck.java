package pr08.models;

import pr08.enums.CardSuits;
import pr08.enums.CardRanks;

import java.util.ArrayList;
import java.util.List;

public class Deck{

    private List<Card> cards;

    public Deck() {
        this.cards = new ArrayList<>();
        this.createDeck();
    }

    private void createDeck() {
        CardRanks[] cardRanks = CardRanks.values();
        CardSuits[] cardSuits = CardSuits.values();

        for (CardRanks cardRank : cardRanks) {
            for (CardSuits cardSuit : cardSuits) {
                Card card = new Card(cardRank, cardSuit);
                this.cards.add(card);
            }
        }
    }

    public void removeCard(Card card) {
        this.cards.remove(card);
    }

    public boolean isCardInDeck(Card card) {
        return this.cards.contains(card);
    }
}
