package DefiningClasses.RawData;

import java.util.*;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Map<String,List<Car>> Cars= new LinkedHashMap<>();

        int n = Integer.parseInt(scanner.nextLine());

        while(n-->0) {
            List<String> Input = Arrays.stream(scanner.nextLine().split(" ")).collect(Collectors.toList());
            String Model = Input.get(0);
            int EngineSpeed = Integer.parseInt(Input.get(1));
            int EnginePower = Integer.parseInt(Input.get(2));
            int CargoWeight = Integer.parseInt(Input.get(3));
            String CargoType = Input.get(4);
            double Pressure1 = Double.parseDouble(Input.get(5));
            int Age1 = Integer.parseInt(Input.get(6));
            double Pressure2 = Double.parseDouble(Input.get(7));
            int Age2 = Integer.parseInt(Input.get(8));
            double Pressure3 = Double.parseDouble(Input.get(9));
            int Age3 = Integer.parseInt(Input.get(10));
            double Pressure4 = Double.parseDouble(Input.get(11));
            int Age4 = Integer.parseInt(Input.get(12));
            if (!Cars.containsKey(CargoType)) {
                Cars.put(CargoType, new ArrayList<>());
            }

            Car car = new Car(Model, EnginePower, EngineSpeed, CargoWeight, CargoType, Pressure1, Age1, Pressure2, Age2, Pressure3, Age3, Pressure4, Age4);
            Cars.get(CargoType).add(car);
        }
        String Type = scanner.nextLine();
        switch (Type){
            case"fragile":
                Cars.get("fragile").stream()
                        .filter(Car::isItTrue)
                        .forEach(a-> System.out.printf("%s\n",a.getModel()));
                break;
            case"flamable":
                Cars.get("flamable").stream()
                        .filter(a->a.getEngineSpeed()>250)
                        .forEach(a->System.out.printf("%s\n",a.getModel()));
                break;
        }
    }
}
