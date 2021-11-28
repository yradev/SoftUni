package JavaFundamentals.Exercises.DataTypesAndVariables;

import java.util.Scanner;

public class IntegerOperations {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int a = Integer.parseInt(in.nextLine());
        int b = Integer.parseInt(in.nextLine());
        int c = Integer.parseInt(in.nextLine());
        int d = Integer.parseInt(in.nextLine());

        int e = ((a+b)/c)*d;

        System.out.println(e);
    }
        }
