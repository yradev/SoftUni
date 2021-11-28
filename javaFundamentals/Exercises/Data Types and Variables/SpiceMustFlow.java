package datatypesandvariables;

import java.util.Scanner;

public class SpiceMustFlow {
    public static void main(String[] args) {
        Scanner Input = new Scanner(System.in);
        int StartingYield = Integer.parseInt(Input.nextLine());
        int TotalConsumations = 0;
        int Days = 0;

        if (StartingYield >= 100) {
            while (StartingYield >= 100) {
                Days++;
                TotalConsumations += StartingYield - 26;
                StartingYield -= 10;
            }
            TotalConsumations -= 26;
            System.out.printf("%s\n%s", Days, TotalConsumations);
        } else {
            System.out.printf("%s%n%s", 0, 0);
        }
    }
}
