package JavaFundamentals.Exercises.Methods;

import java.util.*;

public class AddAndSubtract {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int a = Integer.parseInt(in.nextLine());
        int b = Integer.parseInt(in.nextLine());
        int c = Integer.parseInt(in.nextLine());

        int d = sum(a,b)-c;
        System.out.println(d);

    }

    public static int sum(int a, int b) {
        int d=a+b;

        return d;
    }
}