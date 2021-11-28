package javaFundamentals.Exercises.DataTypesAndVariables;

import java.util.Scanner;

public class Pokemon {
    public static void main(String[] args) {
        Scanner Input = new Scanner(System.in);
        int N = Integer.parseInt(Input.nextLine());
        int M = Integer.parseInt(Input.nextLine());
        int Y = Integer.parseInt(Input.nextLine());
        int count = 0;
        double HalfN = N*0.50;
        while (N >= M) {
            if (N == HalfN && Y>0) {
                N /= Y;
                if(N<M) {
                    break;
                }
            }
            N-=M;
            count++;
        }
        System.out.printf("%s\n%s", N, count);
    }
}
