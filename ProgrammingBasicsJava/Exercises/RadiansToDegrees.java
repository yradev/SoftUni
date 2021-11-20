package Exercises;
import java.util.*;
public class RadiansToDegrees {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        double rad = Double.parseDouble(in.nextLine());
        double gradus = rad*180/Math.PI;
        System.out.printf("%.0f",gradus);
    }
}