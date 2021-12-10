package JavaOOP.Exercises.Abstraction.CardsWithPower;

public class Cards {
    private int power;
    private String rank;
    private String suit;

    Cards(String rank, String group) {
        power = ranks.valueOf(rank).getNumber()+ suits.valueOf(group).getNumber();
        this.rank = rank;
        this.suit = group;
    }

    @Override
    public String toString(){
        return String.format("Card name: %s of %s; Card power: %s",rank, suit,power);
    }
}
