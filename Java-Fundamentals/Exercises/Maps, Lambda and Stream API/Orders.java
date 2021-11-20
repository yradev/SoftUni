package Maps;

import java.util.*;
import java.util.stream.Collectors;

public class Orders {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        Map<String, List<Double>> DataBase = new LinkedHashMap<>();

        while (true) {
            String Input = input.nextLine();
            if (Input.equalsIgnoreCase("buy")) {
                break;
            }

            List<String> Split = Arrays.stream(Input.split(" ")).collect(Collectors.toList());

            String Name = Split.get(0);
            double Price = Double.parseDouble(Split.get(1));
            double Quantity = Integer.parseInt(Split.get(2));

            if (!DataBase.containsKey(Name)) {
                DataBase.put(Name, Arrays.asList(Price, Quantity));
            } else {
                DataBase.get(Name).set(0, Price);
                double tempValue = DataBase.get(Name).get(1) + Quantity;
                DataBase.get(Name).set(1, tempValue);
            }
        }

        Map <String,Double> DataBaseNew = DataBase.entrySet().stream()
                .collect(Collectors.toMap(Map.Entry::getKey, a->a.getValue().get(0)*a.getValue().get(1), (e1, e2) -> e1, LinkedHashMap::new));

        DataBaseNew.forEach((a,b)-> System.out.printf("%s -> %.2f\n",a,b));
    }
}
