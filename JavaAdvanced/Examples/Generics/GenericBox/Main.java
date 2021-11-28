package JavaAdvanced.Examples.Generics.GenericBox;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Box <String> box = new Box<>();
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        while(n-->0){
            String Input = scanner.nextLine();
            box.add(Input);
        }
        System.out.println(box);
    }
}
