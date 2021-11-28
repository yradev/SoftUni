package javaFundamentals.Exercises.BasicSyntaxConditionalStatementsAndLoops;

import java.util.*;
import java.util.Scanner;

public class RageExpenses {
    public static void main(String[] args) {
        Scanner Input = new Scanner(System.in);
        int LostGamesCount = Integer.parseInt(Input.nextLine());
        double HeadsetPrice = Double.parseDouble(Input.nextLine());
        double MousePrice = Double.parseDouble(Input.nextLine());
        double KeyboardPrice = Double.parseDouble(Input.nextLine());
        double DisplayPrice = Double.parseDouble(Input.nextLine());

        int KeyboardCount = 0;
        Map<String,Double> Trashed = new LinkedHashMap<>();
        Trashed.putIfAbsent("Keyboard",0.0);


        for(int i=1;i<=LostGamesCount; i++){
            if(i%2==0){
                GetMap(Trashed,"HeadSet",HeadsetPrice);
            }
            if(i%3==0){
                GetMap(Trashed,"Mouse",MousePrice);
            }

            if(i%2==0 && i%3==0){
                GetMap(Trashed,"Keyboard",KeyboardPrice);
                KeyboardCount++;
            }

            if(KeyboardCount==2){
                GetMap(Trashed,"Display",DisplayPrice);
                KeyboardCount=0;
            }
        }

        double Total = Trashed.values().stream()
                .mapToDouble(d->d)
                .sum();

        System.out.printf("Rage expenses: %.2f lv.",Total);
    }

    public static void GetMap(Map<String, Double> trashed,String key,double Price) {
        trashed.putIfAbsent(key,0.0);
        double tempValue = trashed.get(key)+Price;
        trashed.put(key,tempValue);
    }
}
