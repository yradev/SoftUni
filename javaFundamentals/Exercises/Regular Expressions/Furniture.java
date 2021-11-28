package RegEx;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Furniture {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        String Input = input.nextLine();
        String pattern = ">>(?<FurnitureName>[A-z]+)<<(?<price>(?:\\d+\\.\\d+|\\d+))!(?<Quantity>\\d+)";
        double TotalPrice = 0;
        System.out.println("Bought furniture:");
        while(!Input.equalsIgnoreCase("Purchase")) {
            Pattern regex = Pattern.compile(pattern);
            Matcher matcher = regex.matcher(Input);
            if(matcher.find()){
                System.out.println(matcher.group("FurnitureName"));
                double Price = Double.parseDouble(matcher.group("price"));
                double Quantity = Double.parseDouble(matcher.group("Quantity"));
                TotalPrice+=Price*Quantity;
            }
            Input=input.nextLine();
        }

        System.out.printf("Total money spend: %.2f",TotalPrice);
    }
}
