package JavaOOP.Exercises.Abstraction.TrafficLights;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        TrafficLights trafficLights = setTrafficLights(scanner);
        int numberOfMoves = Integer.parseInt(scanner.nextLine());
        doUpdatesAndPrintResults(numberOfMoves,trafficLights);
    }

    private static TrafficLights setTrafficLights(Scanner scanner) {
        String [] lights = scanner.nextLine().split("\\s+");
        return new TrafficLights(lights);
    }

    private static void doUpdatesAndPrintResults(int numberOfMoves, TrafficLights trafficLights) {
        for(int i=1;i<=numberOfMoves;i++){
            trafficLights.Update();
            trafficLights.PrintResult();
        }
    }
}
