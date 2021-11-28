package JavaAdvanced.Examples.DefiningClasses.CarSalesman;

import java.util.*;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Map<String,Engine>engines = new LinkedHashMap<>();
        List<Car>cars = new ArrayList<>();
        fillEngine(scanner,engines);
        fillCar(scanner,cars);

        for (Car car : cars) {
            System.out.printf("%s:\n",car.getModel());
            engines.entrySet().stream()
                    .filter(a->a.getKey().equals(car.getEngine()))
                    .forEach(a-> System.out.printf("%S:\n%s",a.getKey(),a.getValue()));
            System.out.printf("Weight: %s\nColor: %s\n",car.getWeight(),car.getColor());
        }

    }

    private static void fillEngine(Scanner scanner, Map<String,Engine> engines) {
        int n = Integer.parseInt(scanner.nextLine());
        while(n-->0){
            List<String>Input = Arrays.stream(scanner.nextLine().split(" ")).collect(Collectors.toList());
            String Model = Input.get(0);
            int Power = Integer.parseInt(Input.get(1));
            String Displacement = "n/a";
            String Efficiency = "n/a";
            if(Input.size()==3){
                try{
                    int tempDisplacement = Integer.parseInt(Input.get(2));
                    Displacement=String.valueOf(tempDisplacement);
                }catch(NumberFormatException e){
                    Efficiency=Input.get(2);
                }
            }
            else if(Input.size()==4){
                Displacement=Input.get(2);
                Efficiency=Input.get(3);
            }

            Engine engine = new Engine(Model,Power,Displacement,Efficiency);
            engines.put(Model,engine);
        }
    }

    private static void fillCar(Scanner scanner, List<Car> cars) {
        int m = Integer.parseInt(scanner.nextLine());
        while(m-->0){
            List<String>Input = Arrays.stream(scanner.nextLine().split(" ")).collect(Collectors.toList());
            String Model = Input.get(0);
            String Engine = Input.get(1);
            String Weight = "n/a";
            String Color = "n/a";
            if(Input.size()==3){
                try{
                    int tempWeight = Integer.parseInt(Input.get(2));
                    Weight = String.valueOf(tempWeight);

                }catch (NumberFormatException e){
                    Color=Input.get(2);
                }
            }else if(Input.size()==4){
                Weight=Input.get(2);
                Color=Input.get(3);
            }
            Car car = new Car(Model,Engine,Weight,Color);
            cars.add(car);
        }
    }
}
