package JavaOOP.Exercises.Abstraction.CardsWithPower;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String Card = scanner.nextLine();
        String Club = scanner.nextLine();
        Cards card = new Cards(Card,Club);
        System.out.println(card);
    }
}
