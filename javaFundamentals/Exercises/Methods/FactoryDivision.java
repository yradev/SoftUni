package javaFundamentals.Exercises.Methods;

import java.util.*;

public class FactoryDivision {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n1 =Integer.parseInt(in.nextLine());
        int n2= Integer.parseInt(in.nextLine());
        double factorial1 = GetFactorial(n1);
        double factorial2 = GetFactorial(n2);

        double sum=factorial1/factorial2;
        System.out.printf("%.2f",sum);
    }

    public static double GetFactorial(double n) {
        double factorial = 1;
        for (int i = 1; i <= n; i++) {
            factorial *= i;
        }
        return factorial;
    }
}
