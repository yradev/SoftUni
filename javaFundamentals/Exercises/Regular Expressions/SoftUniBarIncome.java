package RegEx;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class SoftUniBarIncome {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        String Regex = "%(?<CustomerName>[A-Z]*[a-z]*)%[^|$%.]*<(?<Product>\\w+)>[^|$%.]*\\|(?<Count>\\d+)\\|[^|$%.]*?(?<price>\\d+\\.*\\d*)\\$$";
        double Total = 0;
        while (true) {
            String Input = input.nextLine();
            if (Input.equalsIgnoreCase("end of shift")) {
                break;
            }

            Pattern pattern = Pattern.compile(Regex);
            Matcher matcher = pattern.matcher(Input);
            double tempMoney = 0;
            while (matcher.find()) {
                int Count = Integer.parseInt(matcher.group("Count"));
                double Price = Double.parseDouble(matcher.group("price"));
                tempMoney = Count * Price;
                System.out.printf("%s: %s - %.2f\n", matcher.group("CustomerName"), matcher.group("Product"), tempMoney);
            }

            Total += tempMoney;
        }

        System.out.printf("Total income: %.2f", Total);
    }
}