package JavaOOP.Exercises.Abstraction.CardSuit;

public class Main {
    public static void main(String[] args) {
        System.out.println("Card Suits:");
        for (dataBase value : dataBase.values()) {
            System.out.printf("Ordinal value: %s; Name value: %s\n",value.ordinal(),value.name());
        }
    }
}
