package Question1;

import javax.swing.*;
import java.util.ArrayList;

public class WarGame {
    private static DeckOfCards deckOfCards;
    private static ArrayList<Card> player1Deck;
    private static ArrayList<Card> player2Deck;
    private static final int HALF_DECK = 26;
    private static final int NUMBER_OF_CARDS = 52;

    public static void main(String[] args) {
        // Initialize the deck of cards
        deckOfCards = new DeckOfCards();
        deckOfCards.shuffle();

        // Divide the deck of cards into two parts
        divideDeck();

        // Start the game
        startGame();
    }

    private static void divideDeck() {
        ArrayList<Card> deck = deckOfCards.getDeck();
        player1Deck = new ArrayList<>(deck.subList(0, HALF_DECK));
        player2Deck = new ArrayList<>(deck.subList(HALF_DECK, NUMBER_OF_CARDS));
    }

    private static void startGame() {
        int choice = JOptionPane.showConfirmDialog(null, "Start the game?", "War Game", JOptionPane.YES_NO_OPTION);
        if (choice == JOptionPane.YES_OPTION) {
            playRound();
        } else {
            JOptionPane.showMessageDialog(null, "Game canceled.", "War Game", JOptionPane.INFORMATION_MESSAGE);
        }
    }

    private static void playRound() {
        if (player1Deck.isEmpty() || player2Deck.isEmpty()) {
            endGame();
            return;
        }

        // Prompt user to continue
        int choice = JOptionPane.showConfirmDialog(null, "Play next round?", "War Game", JOptionPane.YES_NO_OPTION);
        if (choice == JOptionPane.NO_OPTION) {
            endGame();
            return;
        }

        Card player1Card = player1Deck.remove(0);
        Card player2Card = player2Deck.remove(0);

        // Display cards
        JOptionPane.showMessageDialog(null, "Player 1: " + player1Card + "\nPlayer 2: " + player2Card, "Round Result", JOptionPane.INFORMATION_MESSAGE);

        // Determine the winner
        int comparison = player1Card.compareTo(player2Card);
        if (comparison > 0) {
            JOptionPane.showMessageDialog(null, "Player 1 wins this round!", "Round Winner", JOptionPane.INFORMATION_MESSAGE);
            player1Deck.add(player1Card);
            player1Deck.add(player2Card);
        } else if (comparison < 0) {
            JOptionPane.showMessageDialog(null, "Player 2 wins this round!", "Round Winner", JOptionPane.INFORMATION_MESSAGE);
            player2Deck.add(player1Card);
            player2Deck.add(player2Card);
        } else {
            // War status
            JOptionPane.showMessageDialog(null, "It's a draw! War status initiated.", "War", JOptionPane.INFORMATION_MESSAGE);
            initiateWar();
        }

        playRound();
    }

    private static void initiateWar() {
        // Pop cards for war
        Card[] player1Cards = new Card[3];
        Card[] player2Cards = new Card[3];
        for (int i = 0; i < 3; i++) {
            if (player1Deck.isEmpty() || player2Deck.isEmpty()) {
                endGame();
                return;
            }
            player1Cards[i] = player1Deck.remove(0);
            player2Cards[i] = player2Deck.remove(0);
        }

        // Display war cards
        StringBuilder message = new StringBuilder("War Cards:\n");
        for (int i = 0; i < 3; i++) {
            message.append("Player 1: ").append(player1Cards[i]).append("\n");
            message.append("Player 2: ").append(player2Cards[i]).append("\n");
        }
        JOptionPane.showMessageDialog(null, message.toString(), "War Cards", JOptionPane.INFORMATION_MESSAGE);

        // Last card comparison
        Card player1LastCard = player1Cards[2];
        Card player2LastCard = player2Cards[2];
        int comparison = player1LastCard == null || player2LastCard == null ? 0 : player1LastCard.compareTo(player2LastCard);
        if (comparison > 0) {
            JOptionPane.showMessageDialog(null, "Player 1 wins the war!", "War Winner", JOptionPane.INFORMATION_MESSAGE);
            for (Card card : player1Cards) {
                if (card != null) {
                    player1Deck.add(card);
                }
            }
            for (Card card : player2Cards) {
                if (card != null) {
                    player1Deck.add(card);
                }
            }
        } else if (comparison < 0) {
            JOptionPane.showMessageDialog(null, "Player 2 wins the war!", "War Winner", JOptionPane.INFORMATION_MESSAGE);
            for (Card card : player1Cards) {
                if (card != null) {
                    player2Deck.add(card);
                }
            }
            for (Card card : player2Cards) {
                if (card != null) {
                    player2Deck.add(card);
                }
            }
        } else {
            // War continues
            JOptionPane.showMessageDialog(null, "War continues!", "War", JOptionPane.INFORMATION_MESSAGE);
            initiateWar();
        }
    }

    private static void endGame() {
        String winner;
        if (player1Deck.isEmpty()) {
            winner = "Player 2";
        } else if (player2Deck.isEmpty()) {
            winner = "Player 1";
        } else {
            winner = "No one"; // This should not happen
        }
        JOptionPane.showMessageDialog(null, "Game Over! " + winner + " wins!", "Game Over", JOptionPane.INFORMATION_MESSAGE);
    }

}
