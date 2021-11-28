package Exercises.Basics;

import java.util.Scanner;

public class PrintAndSum {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int start = Integer.parseInt(in.nextLine());
        int end = Integer.parseInt(in.nextLine());
        int sum = 0;
        for(int delay = start; delay<=end; delay++){

            System.out.printf("%s ",delay);
            sum+=delay;
        }
        System.out.println();
        System.out.printf("Sum: %s",sum);
    }
}
