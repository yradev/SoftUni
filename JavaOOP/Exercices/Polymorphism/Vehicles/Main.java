package Polymorphism.Vehicles;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Vehicles car = setCar(scanner);
        Vehicles truck = setTruck(scanner);
        List<Vehicles> vehicles = List.of(car,truck);
        int count = Integer.parseInt(scanner.nextLine());
        while(count-->0){
            String [] tokens = scanner.nextLine().split(" ");
            double distance = Double.parseDouble(tokens[2]);
            switch (tokens[0]){
                case"Drive":
                    if(tokens[1].equals("Car")){
                        System.out.println(car.Drive(distance));
                    }else{
                        System.out.println(truck.Drive(distance));
                    }break;
                case"Refuel":
                    if(tokens[1].equals("Car")){
                        car.Refuel(distance);
                    }else{
                        truck.Refuel(distance);
                    }break;
            }
        }

        vehicles.forEach(System.out::println);
    }

    private static Vehicles setTruck(Scanner scanner) {
        String [] tokens1 = scanner.nextLine().split(" ");
        double fuelQuantity = Double.parseDouble(tokens1[1]);
        double fuelConsumptioninLitersPerKm = Double.parseDouble(tokens1[2]);
        return new Truck(fuelQuantity,fuelConsumptioninLitersPerKm);

    }

    private static Vehicles setCar(Scanner scanner) {
        String [] tokens1 = scanner.nextLine().split(" ");
        double fuelQuantity = Double.parseDouble(tokens1[1]);
        double fuelConsumptioninLitersPerKm = Double.parseDouble(tokens1[2]);
        return new Car(fuelQuantity,fuelConsumptioninLitersPerKm);
    }
}
