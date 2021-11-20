package Exercises;

import java.util.Scanner;

public class FishTank {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int dyljina = Integer.parseInt(in.nextLine());
        int shirochina = Integer.parseInt(in.nextLine());
        int visochina = Integer.parseInt(in.nextLine());
        double procent = Double.parseDouble(in.nextLine());

        double obem = dyljina*shirochina*visochina;
        double zaetost = obem*0.001;
        zaetost-=(zaetost*procent)/100;
        System.out.printf("%.2f",zaetost);
    }
}
