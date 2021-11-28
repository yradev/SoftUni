package JavaAdvanced.Exams.August182021;

import java.util.*;
import java.util.stream.Collectors;

public class PastryShop {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayDeque<Integer> Liquids = new ArrayDeque<>();
        Arrays.stream(scanner.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt).forEach(Liquids::offer);

        ArrayDeque<Integer> Ingredients = new ArrayDeque<>();
        Arrays.stream(scanner.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt).forEach(Ingredients::push);

        Map<String,Integer>Cooked = new LinkedHashMap<>();
        Cooked.put("Biscuit",0);
        Cooked.put("Cake",0);
        Cooked.put("Pie",0);
        Cooked.put("Pastry",0);

        while (!Liquids.isEmpty() && !Ingredients.isEmpty()) {
            int FirstLiquid = Liquids.poll();
            int LastIngredient = Ingredients.pop();
            int Sum = FirstLiquid + LastIngredient;

            if (Sum == 25) {
                int newValue = Cooked.get("Biscuit") + 1;
                Cooked.put("Biscuit", newValue);
            } else if (Sum == 50) {
                int newValue = Cooked.get("Cake") + 1;
                Cooked.put("Cake", newValue);
            } else if (Sum == 75) {
                int newValue = Cooked.get("Pastry") + 1;
                Cooked.put("Pastry", newValue);
            } else if (Sum == 100) {
                int newValue = Cooked.get("Pie") + 1;
                Cooked.put("Pie", newValue);
            } else {
                Ingredients.push(LastIngredient + 3);
            }

        }

        boolean isEverythingDOne = true;
        for (Integer value : Cooked.values()) {
            if(value==0){
                isEverythingDOne=false;
                break;
            }
        }

        if(isEverythingDOne){
            System.out.println("Great! You succeeded in cooking all the food!");
        }else{
            System.out.println("What a pity! You didn't have enough materials to cook everything.");
        }

        if(Liquids.isEmpty()){
            System.out.println("Liquids left: none");
        }else{
            System.out.printf("Liquids left: %s\n",Liquids.stream().map(String::valueOf).collect(Collectors.joining(", ")));
        }

        if(Ingredients.isEmpty()){
            System.out.println("Ingredients left: none");
        }else{
            System.out.printf("Ingredients left: %s\n",Ingredients.stream().map(String::valueOf).collect(Collectors.joining(", ")));
        }

        Cooked.forEach((key, value) -> System.out.printf("%s: %s\n",key,value));
    }
}
