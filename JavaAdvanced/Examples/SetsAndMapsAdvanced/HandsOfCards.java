package JavaAdvanced.Examples.SetsAndMapsAdvanced;

import java.util.*;
import java.util.stream.Collectors;

public class HandsOfCards {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String Input = scanner.nextLine();
        Map<String,Set<String>> CardsDataBase = new LinkedHashMap<>();
        while(!Input.equals("JOKER")){
            List<String>Split = Arrays.stream(Input.split(":\\s")).collect(Collectors.toList());
            String Name = Split.get(0);
            List<String>Cards = Arrays.stream(Split.get(1).split(", ")).collect(Collectors.toList());
            if(!CardsDataBase.containsKey(Name)){
                CardsDataBase.put(Name,new LinkedHashSet<>());
            }
                for (String card : Cards) {
                    CardsDataBase.get(Name).add(card);
                }
            Input=scanner.nextLine();
        }

        CardsDataBase.forEach((key, value) -> {
            int Sum = 0;
            for (String b : value) {
                int Num1 = 0;
                int Num2 = 0;
                if (b.contains("J") || b.contains("Q") || b.contains("K") || b.contains("A")) {
                    if (b.contains("J")) {
                        Num1 = 11;
                    }
                    if (b.contains("Q")) {
                        Num1 = 12;
                    }
                    if (b.contains("K")) {
                        Num1 = 13;
                    }
                    if (b.contains("A")) {
                        Num1 = 14;
                    }
                } else {
                    Num1 = Integer.parseInt(b.substring(0, b.length() - 1));
                }

                switch (b.charAt(b.length() - 1)) {
                    case 'S':
                        Num2 = 4;
                        break;
                    case 'H':
                        Num2 = 3;
                        break;
                    case 'D':
                        Num2 = 2;
                        break;
                    case 'C':
                        Num2 = 1;
                        break;
                }
                Sum += Num1 * Num2;
            }

            System.out.printf("%s: %s\n", key, Sum);
        });
    }
}
