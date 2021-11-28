package JavaAdvanced.Examples.Generics.GenericBoxIntigers;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Box <Integer> box = new Box<>();
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        while(n-->0){
            int Input = Integer.parseInt(scanner.nextLine());
            box.add(Input);
        }
        System.out.println(box);
    }
}
