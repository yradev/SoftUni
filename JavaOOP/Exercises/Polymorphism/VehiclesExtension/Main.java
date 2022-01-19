package Polymorphism.VehiclesExtension;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Vehicles> vehicles = new ArrayList<>();
        fillVehiclesList(3,scanner,vehicles);
        int count = Integer.parseInt(scanner.nextLine());
        while(count-->0){
            String [] tokens = scanner.nextLine().split(" ");
            String vehicleName = tokens[1];
            Vehicles vehicle = getVehicle(vehicles,vehicleName);
            try {
                doMove(tokens[0], vehicle, Double.parseDouble(tokens[2]));
            }catch (IllegalStateException e){
                System.out.println(e.getMessage());
            }
        }
        vehicles.forEach(System.out::println);
    }

    private static void fillVehiclesList(int counter, Scanner scanner, List<Vehicles>vehicles) {
        for(int count=1;count<=counter;count++){
            String [] tokens = scanner.nextLine().split(" ");
            String name = tokens[0];
            double fuelQuantity = Double.parseDouble(tokens[1]);
            double fuelConsumptioninLitersPerKm = Double.parseDouble(tokens[2]);
            double fuelCapacity = Double.parseDouble(tokens[3]);
            Vehicles vehicle = null;
            switch (name){
                case"Car":
                    vehicle = new Car(fuelQuantity,fuelConsumptioninLitersPerKm,fuelCapacity);
                    break;
                case"Truck":
                    vehicle = new Truck(fuelQuantity,fuelConsumptioninLitersPerKm,fuelCapacity);
                    break;
                case"Bus":
                    vehicle = new Bus(fuelQuantity,fuelConsumptioninLitersPerKm,fuelCapacity);
                    break;
            }
            vehicles.add(vehicle);
        }
    }

    private static Vehicles getVehicle(List<Vehicles>vehicles,String vehicleName) {
        Vehicles vehicle = null;
        for (Vehicles vehicle1 : vehicles) {
            if(vehicle1.getClass().getSimpleName().equals(vehicleName)){
                vehicle = vehicle1;
            }
        }
        return vehicle;
    }


    private static void doMove(String move, Vehicles vehicle, double input) {
        switch (move){
            case"Drive":
                System.out.println(vehicle.Drive(input));
                break;
            case"Refuel":
                if(input<=0){
                    throw new IllegalStateException("Fuel must be a positive number");
                }
                if(!vehicle.isValid(input)){
                    throw new IllegalStateException("Cannot fit fuel in tank");
                }
                vehicle.Refuel(input);
                break;
            case"DriveEmpty":
                if(vehicle.getClass().getSimpleName().equals("Bus")){
                    System.out.println(vehicle.DriveEmpty(input));
                }
        }
    }
}
