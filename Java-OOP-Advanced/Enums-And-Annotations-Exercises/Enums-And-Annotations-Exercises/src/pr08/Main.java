package pr08;

import pr08.enums.CardRanks;
import pr08.enums.CardSuits;
import pr08.models.Card;
import pr08.models.Deck;
import pr08.models.Player;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    private static final int PLAYERS_COUNT = 2;

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        Player[] players = new Player[PLAYERS_COUNT];

        for (int i = 0; i < players.length; i++) {
            String playerName = reader.readLine().trim();
            Player player = new Player(playerName);
            players[i] = player;
        }

        Deck deck = new Deck();

        for (int i = 0; i < players.length; i++) {
            int cardsCountForPlayer = 0;
            Player player = players[i];

            while (cardsCountForPlayer < Player.CARDS_PER_PLAYER) {
                String cardName = reader.readLine().trim().toUpperCase();
                String[] cardData = cardName.split("\\s+");

                try {
                    boolean isCardCanBeAddedToDeck = isCardCanBeAddedToDeck(deck, cardData);
                    if (isCardCanBeAddedToDeck) {
                        String rank = cardData[0];
                        String suit = cardData[2];

                        CardRanks cardRank = CardRanks.valueOf(rank);
                        CardSuits cardSuit = CardSuits.valueOf(suit);

                        Card card = new Card(cardRank, cardSuit);

                        player.addCard(card);
                        deck.removeCard(card);
                        cardsCountForPlayer++;
                    }
                } catch (IllegalArgumentException iae) {
                    System.out.println(iae.getMessage());
                }
            }
        }

        printWinner(players);
    }

    private static void printWinner(Player[] players) {
        Player player1 = players[0];
        Player player2 = players[1];

        String winnerName = null;
        Card biggestCard = null;

        if (player1.getHighestPoweredCard().getCardPower()
                >= player2.getHighestPoweredCard().getCardPower()) {

            winnerName = player1.getName();
            biggestCard = player1.getHighestPoweredCard();
        } else {
            winnerName = player2.getName();
            biggestCard = player2.getHighestPoweredCard();
        }

        System.out.printf("%s wins with %s of %s.%n",
                winnerName,
                biggestCard.getCardRank(),
                biggestCard.getCardSuit());
    }

    private static boolean isCardCanBeAddedToDeck(Deck deck, String[] cardData) {

        if (cardData.length != 3) {
            throw new IllegalArgumentException("No such card exists.");
        }

        String rank = cardData[0];
        String suit = cardData[2];

        CardRanks cardRank;
        CardSuits cardSuit;

        try {
            cardRank = CardRanks.valueOf(rank);
            cardSuit = CardSuits.valueOf(suit);
        } catch (Exception exception) {
            System.out.println("No such card exists.");
            return false;
        }

        Card card = new Card(cardRank, cardSuit);
        if (deck.isCardInDeck(card)) {
            return true;
        } else {
            throw new IllegalArgumentException("Card is not in the deck.");
        }
    }
}
