package JavaOOP.Exercises.Encapsulation.ClassBoxDataValidation;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double length = Double.parseDouble(scanner.nextLine());
        double width = Double.parseDouble(scanner.nextLine());
        double height = Double.parseDouble(scanner.nextLine());

        try{
            Box box = new Box(length,width,height);
            System.out.printf("Surface Area - %.2f\nLateral Surface Area - %.2f\nVolume - %.2f",box.calculateSurfaceArea(),box.calculateLateralSurfaceArea(),box.calculateVolume());
        }catch (IllegalStateException e){
            System.out.println(e.getMessage());
        }
    }
}
