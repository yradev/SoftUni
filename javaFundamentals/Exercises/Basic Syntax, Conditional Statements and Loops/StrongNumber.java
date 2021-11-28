package Exercises.Basics;

import java.util.Scanner;

public class StrongNumber {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String chislo = in.nextLine();

        int total = 0;

        for(int i = 0; i<=chislo.length()-1; i++) {
            int chislo1 = chislo.charAt(i) - 48;
            int result = 1;
            for(int b = 1; b<=chislo1; b++){
                result*=b;
            }
            total+=result;
        }

        int startchislo = Integer.parseInt(chislo);
        if(startchislo==total) {
            System.out.println("yes");
        }else{
            System.out.println("no");
        }
    }
}
