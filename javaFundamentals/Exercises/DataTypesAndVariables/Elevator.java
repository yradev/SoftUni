package javaFundamentals.Exercises.DataTypesAndVariables;

import java.util.Scanner;

public class Elevator {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int a = Integer.parseInt(in.nextLine());
        int b = Integer.parseInt(in.nextLine());
        System.out.printf("%.0f",Math.ceil((double)a/b));
    }
}
