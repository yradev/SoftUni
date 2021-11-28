package javaFundamentals.Exercises.Methods;

import java.util.*;

public class NxNMatrix {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int number = Integer.parseInt(in.nextLine());
        for(int i =0; i<number; i++) {
            ForCicle(number);
            System.out.println();
        }
    }

    public static void ForCicle(int number) {
        for(int i =0; i<number; i++){
            System.out.printf("%s ",number);
        }
    }
}