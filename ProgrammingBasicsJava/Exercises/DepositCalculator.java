package ProgrammingBasicsJava.Exercises;
import java.util.*;
public class DepositCalculator {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        double depozit = Double.parseDouble(in.nextLine());
        int srok = Integer.parseInt(in.nextLine());
        double lihva = Double.parseDouble(in.nextLine());
        lihva*=depozit/100;
        double suma = depozit+srok*((lihva)/12);
        System.out.printf("%.2f",suma);
    }
}