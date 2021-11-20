package Exercises;

import java.util.Scanner;

public class CharityCampaign {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int dni = Integer.parseInt(in.nextLine());
        int sladkari = Integer.parseInt(in.nextLine());
        double torti = Double.parseDouble(in.nextLine());
        double gofreti = Double.parseDouble(in.nextLine());
        double palachinki = Double.parseDouble(in.nextLine());

        torti*=45;
        gofreti*=5.80;
        palachinki*=3.20;

        double total = torti+gofreti+palachinki;
        total*=sladkari*dni;
        double razhodi = total/8;
        total-=razhodi;
        System.out.printf("%.2f",total);
    }
}
