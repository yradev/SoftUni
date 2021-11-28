package datatypesandvariables;

import java.util.Scanner;

public class SumDigits {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String n = in.nextLine();
        int total = 0;
        for(int i=0; i<=n.length()-1; i++){
            total+=n.charAt(i)-48;
        }

        System.out.println(total);
    }
}
