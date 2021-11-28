package javaFundamentals.Exercises.DataTypesAndVariables;

import java.util.Scanner;

public class TriplesOfLatinLetters {
    public static void main(String[] args) {
        Scanner Input = new Scanner(System.in);
        int n = Integer.parseInt(Input.nextLine());
        for(int i=0; i<=n-1; i++){
            for(int b=0;b<=n-1;b++){
                for(int c=0;c<=n-1;c++){

                    System.out.printf("%s%s%s",(char)('a'+i),(char)('a'+b),(char)('a'+c));
                    System.out.println("");
                }
            }
        }
    }
}