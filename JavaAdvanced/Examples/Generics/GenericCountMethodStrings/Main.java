package JavaAdvanced.Examples.Generics.GenericCountMethodStrings;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N = Integer.parseInt(scanner.nextLine());
        DataBase<String> dataBase = new DataBase<>();
        while(N-->0){
            String Input = scanner.nextLine();
            dataBase.add(Input);
        }
        String Compare = scanner.nextLine();

        System.out.println(dataBase.countOfGreaterItems(Compare));
    }
}
