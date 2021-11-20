package datatypesandvariables;

import java.util.Scanner;

public class PrintPartOfASCII {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int start = Integer.parseInt(in.nextLine());
        int end = Integer.parseInt(in.nextLine());
        for(int i=start; i<=end; i++) {
            char newchar = (char)i;
            System.out.printf("%s ",newchar);
        }
    }
}
