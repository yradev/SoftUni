package datatypesandvariables;

import java.util.Scanner;

public class SumOfChars {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = Integer.parseInt(in.nextLine());
        int total=0;
        for(int i=1; i<=n; i++){
            String character = in.nextLine();
            total+=character.charAt(0);
        }

        System.out.printf("The sum equals: %s",total);
    }
}
