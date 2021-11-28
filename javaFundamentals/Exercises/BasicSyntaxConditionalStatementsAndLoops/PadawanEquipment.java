package javaFundamentals.Exercises.BasicSyntaxConditionalStatementsAndLoops;

import java.util.Scanner;

public class PadawanEquipment {
    public static void main(String[] args) {
        Scanner Input = new Scanner(System.in);
        double AmountOfMoney = Double.parseDouble(Input.nextLine());
        int CountOfStudents = Integer.parseInt(Input.nextLine());
        double LightSabersPrice = Double.parseDouble(Input.nextLine());
        double RobesPrice = Double.parseDouble(Input.nextLine());
        double BeltsPrice = Double.parseDouble(Input.nextLine());

        double LighSabersCount = Math.ceil(CountOfStudents*1.10);
        int freebelts = 0;

        for(int i=1;i<=CountOfStudents;i++){
            if(i%6==0){
                freebelts++;
            }
        }
        double money = (LightSabersPrice*LighSabersCount)+(RobesPrice*CountOfStudents)+(BeltsPrice*(CountOfStudents-freebelts));

        if(AmountOfMoney>=money){
            System.out.printf("The money is enough - it would cost %.2flv.",money);
        }else{
            System.out.printf("George Lucas will need %.2flv more.",money-AmountOfMoney);
        }
    }
}
