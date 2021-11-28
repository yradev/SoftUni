package JavaOOP.Exercises.Abstraction.CardRank;

public class Main {
    public static void main(String[] args) {
        System.out.println("Card Ranks:");
        for (dataBase value : dataBase.values()) {
            System.out.printf("Ordinal value: %s; Name value: %s\n",value.ordinal(),value.name());
        }
    }
}
