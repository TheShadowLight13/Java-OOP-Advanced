package pr08.models;

import java.util.*;

public class Player {

    public static final int CARDS_PER_PLAYER = 5;

    private String name;
    private List<Card> cards;

    public Player(String name) {
        this.setName(name);
        this.cards = new ArrayList<>();
    }

    public String getName() {
        return this.name;
    }

    private void setName(String name) {
        this.name = name;
    }

    public void addCard(Card card) {
        this.cards.add(card);
    }

    public Card getHighestPoweredCard() {
        Comparator<Card> cardComparator =
                (c1,c2) -> Integer.compare(c1.getCardPower(), c2.getCardPower());
        Card highestPoweredCard = Collections.max(cards, cardComparator);
        return highestPoweredCard;
    }
}
