package Exercises;

import java.util.Scanner;

public class BirthdayParty {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        double naem = Double.parseDouble(in.nextLine());
        double torta = (naem*20)/100;
        double napitki = torta - ((torta*45)/100);
        double animator = naem/3;
        double sum = naem+torta+napitki+animator;
        System.out.println(sum);
    }
}
