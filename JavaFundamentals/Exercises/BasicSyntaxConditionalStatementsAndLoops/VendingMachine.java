package JavaFundamentals.Exercises.BasicSyntaxConditionalStatementsAndLoops;

import java.util.Scanner;

public class VendingMachine {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        double Money = 0;
        while(true) {
            String LookingFor = in.nextLine();

            if (LookingFor.equalsIgnoreCase("start")) {
                while(true){
                    LookingFor = in.nextLine();

                    switch(LookingFor){
                        case "Nuts": if(Money>=2.0){
                            System.out.println("Purchased Nuts");
                            Money-=2.0;
                        }else{
                            System.out.println("Sorry, not enough money");
                        }break;
                        case "Water": if(Money>=0.7){
                            System.out.println("Purchased Water");
                            Money-=0.7;
                        }else{
                            System.out.println("Sorry, not enough money");
                        }break;
                        case "Crisps": if(Money>=1.5){
                            System.out.println("Purchased Crisps");
                            Money-=1.5;
                        }else{
                            System.out.println("Sorry, not enough money");
                        }break;
                        case "Soda": if(Money>=0.8){
                            System.out.println("Purchased Soda");
                            Money-=0.8;
                        }else{
                            System.out.println("Sorry, not enough money");
                        }break;
                        case "Coke": if(Money>=1.0){
                            System.out.println("Purchased Coke");
                            Money-=1.0;
                        }else{
                            System.out.println("Sorry, not enough money");
                        }break;
                        case "End":
                            System.out.printf("Change: %.2f",Money); return;
                        default: System.out.println("Invalid product");
                    }
                }
            }
            double coins = Double.parseDouble(LookingFor);
            if (coins == 0.1 || coins == 0.2 || coins == 0.5 || coins == 1 || coins == 2) {
                Money += coins;
            } else {
                System.out.printf("Cannot accept %.2f", coins);
            }
        }
    }
}
