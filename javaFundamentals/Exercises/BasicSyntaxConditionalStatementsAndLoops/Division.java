package javaFundamentals.Exercises.BasicSyntaxConditionalStatementsAndLoops;

import java.util.Scanner;

public class Division {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int number = Integer.parseInt(in.nextLine());
        int devision = 0;
        if (number % 2 == 0) {
            devision = 2;
        }
        if (number % 3 == 0) {
            devision = 3;
        }
        if (number % 6 == 0) {
            devision = 6;
        }
        if (number % 7 == 0) {
            devision = 7;
        }
        if (number % 10 == 0) {
            devision = 10;
        }

        if (devision != 0) {
            System.out.printf("The number is divisible by %s", devision);
        } else {
            System.out.println("Not divisible");
        }
    }
}
