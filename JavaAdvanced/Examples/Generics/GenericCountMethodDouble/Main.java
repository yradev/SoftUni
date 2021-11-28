package JavaAdvanced.Examples.Generics.GenericCountMethodDouble;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N = Integer.parseInt(scanner.nextLine());
        DataBase<Double> dataBase = new DataBase<>();
        while(N-->0){
            double Input = Double.parseDouble(scanner.nextLine());
            dataBase.add(Input);
        }
        double Compare = Double.parseDouble(scanner.nextLine());

        System.out.println(dataBase.countOfGreaterItems(Compare));
    }
}
