package Exams;

import java.util.Scanner;

public class AgencyProfit {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String name = in.nextLine();
        int OldTickets = Integer.parseInt(in.nextLine());
        int ChildTickets = Integer.parseInt(in.nextLine());
        double PriceOldTicket = Double.parseDouble(in.nextLine());
        double PriceChildTicket = PriceOldTicket-((PriceOldTicket*70)/100);
        double fee = Double.parseDouble(in.nextLine());

        double total = ((OldTickets*PriceOldTicket)+(OldTickets*fee))+((ChildTickets*PriceChildTicket)+(ChildTickets*fee));

        double EarnMoney = (total*20)/100;

        System.out.printf("The profit of your agency from %s tickets is %.2f lv.",name,EarnMoney);
    }
}
