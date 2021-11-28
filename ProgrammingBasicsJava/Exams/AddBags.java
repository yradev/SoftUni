package ProgrammingBasicsJava.Exams;

import java.util.Scanner;

public class AddBags {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        double PriceLuggage20 = Double.parseDouble(in.nextLine());
        double Weight = Double.parseDouble(in.nextLine());
        double fee = 0;
        if(Weight<10){
            fee = (PriceLuggage20*20)/100;
        }else if(Weight>=10 && Weight <=20){
            fee = (PriceLuggage20*50)/100;
        }else if(Weight>20){
            fee = PriceLuggage20;
        }

        int days = Integer.parseInt(in.nextLine());

        if(days>30){
            fee+=(fee*10)/100;
        }else if(days>=7){
            fee+=(fee*15)/100;
        }else{
            fee+=(fee*40)/100;
        }

        int HowMuchLuggage = Integer.parseInt(in.nextLine());

        double TotalFee = HowMuchLuggage*fee;

        System.out.printf("The total price of bags is: %.2f lv.",TotalFee);
    }
}
//
