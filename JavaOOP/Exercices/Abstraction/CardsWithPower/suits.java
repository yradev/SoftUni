package JavaOOP.Exercises.Abstraction.CardsWithPower;

public enum suits {
    CLUBS(0),
    DIAMONDS(13),
    HEARTS(26),
    SPADES(39);

    private int number;
    suits(int number){
        this.number = number;
    }

    public int getNumber() {
        return number;
    }
}
