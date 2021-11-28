package ProgrammingBasicsJava.Exams;

import java.util.Scanner;

public class AluminumJoinery {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int CountJoinery = Integer.parseInt(in.nextLine());
        String TypeOfJoinery = in.nextLine();
        String Delivery = in.nextLine();

        double TotalMoney = 0;

        switch(TypeOfJoinery){
            case "90X130":
                TotalMoney+=110;
                if(CountJoinery>30 && CountJoinery<=60){
                    TotalMoney-=(TotalMoney*5)/100;
                }else if(CountJoinery>60){
                    TotalMoney-=(TotalMoney*8)/100;
                }
                break;
            case"100X150":
                TotalMoney+=140;
                if(CountJoinery>40 && CountJoinery<=80){
                    TotalMoney-=(TotalMoney*6)/100;
                }else if(CountJoinery>80){
                    TotalMoney-=(TotalMoney*10)/100;
                }
                break;
            case"130X180":
                TotalMoney+=190;
                if(CountJoinery>20 && CountJoinery<=50){
                    TotalMoney-=(TotalMoney*7)/100;
                }else if(CountJoinery>50){
                    TotalMoney-=(TotalMoney*12)/100;
                }
                break;
            case"200X300":
                TotalMoney+=250;
                if(CountJoinery>25 && CountJoinery<=50){
                    TotalMoney-=(TotalMoney*9)/100;
                }else if(CountJoinery>50){
                    TotalMoney-=(TotalMoney*14)/100;
                }
                break;
        }

        TotalMoney*=CountJoinery;

        if(Delivery.equalsIgnoreCase("with delivery")){
            TotalMoney+=60;
        }

        if(CountJoinery>99){
            TotalMoney-=(TotalMoney*4)/100;
        }
        if(CountJoinery<10){
            System.out.println("Invalid order");
        }else{
            System.out.printf("%.2f BGN",TotalMoney);
        }
    }
}
