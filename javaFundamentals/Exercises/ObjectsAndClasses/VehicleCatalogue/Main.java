package javaFundamentals.Exercises.ObjectsAndClasses.VehicleCatalogue;
import java.util.*;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        List<Vehicle>vehicles=new ArrayList<>();
        String LookingForCommand = input.nextLine();
        while(!LookingForCommand.equalsIgnoreCase("end")){
            List<String>Split = Arrays.stream(LookingForCommand.split(" ")).collect(Collectors.toList());
            String TypeLooking = Split.get(0);
                String Type = Split.get(0);
                String Model = Split.get(1);
                String Color = Split.get(2);
                int HorsePower = Integer.parseInt(Split.get(3));

                Vehicle vehicle = new Vehicle(Type, Model, Color, HorsePower);
                vehicles.add(vehicle);
            LookingForCommand=input.nextLine();
        }

        LookingForCommand=input.nextLine();

        while(!LookingForCommand.equalsIgnoreCase("close the catalogue")){
            String LookingForModel=LookingForCommand;
           vehicles.stream()
                    .filter(a->a.getModel().equalsIgnoreCase(LookingForModel))
                    .forEach(System.out::println);
            LookingForCommand=input.nextLine();
        }

        boolean CarsHave = false;
        boolean TrucksHave = false;
        for (Vehicle vehicle : vehicles) {
            if(vehicle.getType().equalsIgnoreCase("car")){
                CarsHave=true;
            }

            if(vehicle.getType().equalsIgnoreCase("truck")){
                TrucksHave=true;
            }
        }
        double AverageCars;
        double AverageTrucks;
        if(CarsHave) {
            AverageCars = vehicles.stream()
                    .filter(a -> a.getType().equalsIgnoreCase("car"))
                    .mapToDouble(Vehicle::getHorsepower)
                    .average()
                    .getAsDouble();
        }else{
            AverageCars=0;
        }
        if(TrucksHave) {
            AverageTrucks = vehicles.stream()
                    .filter(a -> a.getType().equalsIgnoreCase("truck"))
                    .mapToDouble(Vehicle::getHorsepower)
                    .average()
                    .getAsDouble();
        }else{
            AverageTrucks=0;
        }
        System.out.printf("Cars have average horsepower of: %.2f.\n", AverageCars);
            System.out.printf("Trucks have average horsepower of: %.2f.\n", AverageTrucks);
        }
    }
