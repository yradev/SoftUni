package Exercises;
import java.util.*;
public class USDToBGN {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        double usd = Double.parseDouble(in.nextLine());
        usd*=1.79549;
        System.out.println(usd);
    }
}