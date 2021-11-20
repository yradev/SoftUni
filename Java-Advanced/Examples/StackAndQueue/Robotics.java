package StackAndQueue;

import java.util.*;
import java.util.stream.Collectors;

public class Robotics {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        List<String> InputSplit = Arrays.stream(input.nextLine().split(";")).collect(Collectors.toList());
        Map<String, Integer> SavedValuesOfRobots = new LinkedHashMap<>();
        for (String s : InputSplit) {
            List<String> Split = Arrays.stream(s.split("-")).collect(Collectors.toList());
            String name = Split.get(0);
            int ProcessTime = Integer.parseInt(Split.get(1));
            SavedValuesOfRobots.put(name, ProcessTime);
        }

        List<Integer> Split = Arrays.stream(input.nextLine().split(":")).map(Integer::parseInt).collect(Collectors.toList());
        int Hours = Split.get(0);
        int Minutes = Split.get(1);
        int Seconds = Split.get(2);
        int TimeInSeconds = ((Hours * 60) * 60) + (Minutes * 60) + Seconds;

        Map<String, Integer> tempRobotsValues = new LinkedHashMap<>();
        for (String s : SavedValuesOfRobots.keySet()) {
            tempRobotsValues.put(s,0);
        }
        ArrayDeque<String> Products = new ArrayDeque<>();
        while (true) {
            String Input = input.nextLine();
            if (Input.equals("End")) {
                break;
            }
            Products.offer(Input);
        }
        while(!Products.isEmpty()) {
            TimeInSeconds++;
            String Product = Products.poll();
            boolean isWorking = false;

            for (Map.Entry<String, Integer> stringIntegerEntry : tempRobotsValues.entrySet()) {
                String RobotName = stringIntegerEntry.getKey();
                if(stringIntegerEntry.getValue()==0 && !isWorking){
                    tempRobotsValues.put(RobotName, SavedValuesOfRobots.get(RobotName));
                    System.out.printf("%s - %s [%s]\n", RobotName, Product, getTime(TimeInSeconds));
                    isWorking = true;
                }

                if(stringIntegerEntry.getValue()>0){
                    tempRobotsValues.put(RobotName, tempRobotsValues.get(RobotName) - 1);
                }
            }

            if(!isWorking){
                Products.offer(Product);
            }
        }
    }

    private static String getTime(int TimeInSeconds) {
        int newSeconds = TimeInSeconds %60;
        int newMinutes = (TimeInSeconds/60)%60;
        int newHours = (TimeInSeconds/(60*60))%24;

        return String.format("%02d:%02d:%02d",newHours,newMinutes,newSeconds);
    }
}
