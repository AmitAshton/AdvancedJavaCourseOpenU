package Question1;

public enum Suit {
    HEARTS("Hearts"),
    DIAMONDS("Diamonds"),
    CLUBS("Clubs"),
    SPADES("Spades");

    private final String name;

    Suit(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
