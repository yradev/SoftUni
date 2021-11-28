package ProgrammingBasicsJava.Exercises;

import java.util.Scanner;

public class VacationBooksList{
        public static void main(String[] args) {
            Scanner in = new Scanner(System.in);
            int page = Integer.parseInt(in.nextLine());
            int page1hour = Integer.parseInt(in.nextLine());
            int days = Integer.parseInt(in.nextLine());
            int pageshours = page/page1hour;
            int nhours = pageshours/days;
            System.out.println(nhours);
        }
}
