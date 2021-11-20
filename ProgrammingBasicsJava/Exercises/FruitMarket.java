package Exercises;

import java.util.Scanner;

public class FruitMarket {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        double cena = Double.parseDouble(in.nextLine());
        double banani = Double.parseDouble(in.nextLine());
        double portokali = Double.parseDouble(in.nextLine());
        double malini = Double.parseDouble(in.nextLine());
        double qgodi = Double.parseDouble(in.nextLine());

        double cmalini = cena-((cena*50)/100);
        double cportokali = cmalini-((cmalini*40)/100);
        double cbanani = cmalini-((cmalini*80)/100);
        qgodi*=cena;
        cmalini*=malini;
        cportokali*=portokali;
        cbanani*=banani;
        double sum = cmalini+cportokali+cbanani+qgodi;

        System.out.printf("%.2f",sum);
    }
}
