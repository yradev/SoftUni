package JavaFundamentals.Exercises.BasicSyntaxConditionalStatementsAndLoops;

import java.util.Scanner;

public class TriangleOfNumbers {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = Integer.parseInt(in.nextLine());
        for(int i = 0; i<=n-1; i++){
            for(int x = 1; x<=i+1; x++){
                System.out.printf("%s ",i+1);
            }
            System.out.println("");
        }
    }
}
