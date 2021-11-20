package Exams;

import java.util.Scanner;

public class BestPlayer {
        public static void main(String[] args) {
            Scanner in = new Scanner(System.in);
            String name1 = "";
            int goals1 = 0;

            while(true){
                String name = in.nextLine();
                if(name.equalsIgnoreCase("end")){
                    break;
                }
                int goals = Integer.parseInt(in.nextLine());

                if(goals>goals1){
                    name1=name;
                    goals1=goals;

                    if(goals>=10){
                        break;
                    }
                }
            }

            System.out.printf("%s is the best player!\n",name1);

            if(goals1>=3){
                System.out.printf("He has scored %s goals and made a hat-trick !!!",goals1);
            }else{
                System.out.printf("He has scored %s goals.",goals1);
            }
        }
    }
