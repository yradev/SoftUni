package javaFundamentals.Exercises.DataTypesAndVariables;
import java.util.*;
import java.util.Scanner;

public class BeerKegs {
    public static void main(String[] args) {
        Scanner Input = new Scanner(System.in);
        Map <String,Double> Kegs = new TreeMap<>();

        int n = Integer.parseInt(Input.nextLine());
        for(int i=1; i<=n; i++){
            String Name = Input.nextLine();
            double Radius = Double.parseDouble(Input.nextLine());
            int Height = Integer.parseInt(Input.nextLine());

            double KegSize = Math.PI*(Radius*Radius)*Height;

            Kegs.put(Name,KegSize);
        }

        Double a = Kegs.values().stream()
                .mapToDouble(Double::doubleValue)
                .max()
                .getAsDouble();

        String b = Kegs.entrySet()
                .stream()
                .filter(entry -> a.equals(entry.getValue()))
                .map(Map.Entry::getKey)
                .findFirst().get();

        System.out.println(b);
    }
}
