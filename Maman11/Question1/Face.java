package Question1;

public enum Face {
    ACE("Ace", 1),
    DEUCE("Deuce", 2),
    THREE("Three", 3),
    FOUR("Four", 4),
    FIVE("Five", 5),
    SIX("Six", 6),
    SEVEN("Seven", 7),
    EIGHT("Eight", 8),
    NINE("Nine", 9),
    TEN("Ten", 10),
    JACK("Jack", 11),
    QUEEN("Queen", 12),
    KING("King", 13);

    private final String face;
    private final int value;

    Face(String face, int value) {
        this.face = face;
        this.value = value;
    }

    public String getFace() {
        return face;
    }

    public int getValue() {
        return value;
    }
}
