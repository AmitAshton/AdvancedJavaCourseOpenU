package Question1;

// Card class represents a playing card.
public class Card {

    private final Face face; // face of card ("Ace", "Deuce", ...)
    private final Suit suit; // suit of card ("Hearts", "Diamonds", ...)

    // two-argument constructor initializes card's face and suit
    public Card(Face cardFace, Suit cardSuit) {
        this.face = cardFace; // initialize face of card
        this.suit = cardSuit; // initialize suit of card
    }

    public Face getFace() {
        return face;
    }

    public int compareTo(Card card2){
        if (this.getFace().getValue() > card2.getFace().getValue()) return 1; // card1 won
        else if (this.getFace().getValue() < card2.getFace().getValue()) return -1; // card2 won
        else return 0; // cards are equal, war game!
    }

    // return String representation of Card
    public String toString() {
        return face.getFace() + " of " + suit.getName();
    }
}
