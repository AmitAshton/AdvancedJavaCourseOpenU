package Question1;

// DeckOfCards class represents a deck of playing cards.
import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.Collections;

public class DeckOfCards {
    private static final int NUMBER_OF_CARDS = 52; // constant # of Cards

    private ArrayList<Card> deck = new ArrayList<>(); // Card array list, used as the deck of cards
    private int currentCard = 0; // index of next Card to be dealt (0-51)

    // constructor fills deck of Cards
    public DeckOfCards() {
        // populate deck with Card objects
        for (Suit suit : Suit.values()) {
            for (Face face : Face.values()) {
                deck.add(new Card(face, suit));
            }
        }
    }

    // shuffle deck of Cards with one-pass algorithm
    public void shuffle() {
        // next call to method dealCard should start at deck[0] again
        currentCard = 0;

        // shuffles the whole array list using Collections.shuffle() method
        Collections.shuffle(deck);
    }

    public ArrayList<Card> getDeck() {
        return deck;
    }
}