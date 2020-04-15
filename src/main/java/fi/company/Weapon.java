package fi.company;

public enum Weapon {
    ROCK(0), PAPER(1), SCISSORS(2);

    private final int value;

    private Weapon(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }
}
