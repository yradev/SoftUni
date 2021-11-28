package JavaFundamentals.Exercises.BasicSyntaxConditionalStatementsAndLoops;

import java.util.Scanner;

public class Vacation {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int people = Integer.parseInt(in.nextLine());
        String group = in.nextLine();
        String day = in.nextLine();

        double total = 0;
        switch(group){
            case "Students":
                switch(day){
                    case "Friday": total = 8.45;break;
                    case "Saturday": total = 9.80;break;
                    case "Sunday": total = 10.46;break;
                }
                if(people>=30){
                    total*=people;
                    total-=(total*15)/100;
                }else{
                    total*=people;
                }
                break;
            case"Business":
                switch(day){
                    case "Friday": total = 10.90;break;
                    case "Saturday": total = 15.60;break;
                    case "Sunday": total = 16;break;
                }
                if(people>=100) {
                    total *= people - 10;
                }else{
                    total*=people;
                }
                break;
            case"Regular":
                switch(day){
                    case "Friday": total = 15;break;
                    case "Saturday": total = 20;break;
                    case "Sunday": total = 22.50;break;
                }
                if(people>=10 && people<=20){
                    total*=people;
                    total-=(total*5)/100;
                }else{
                    total*=people;
                }
                break;
        }

        System.out.printf("Total price: %.2f",total);
    }
}
