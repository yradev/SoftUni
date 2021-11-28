package javaFundamentals.Exercises.BasicSyntaxConditionalStatementsAndLoops;

import java.util.Scanner;

public class Login {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String username = in.nextLine();
        String password = "";
        int count=0;

        for (int i = username.length()-1; i >=0; i--) {
            password += username.charAt(i);
        }

        while(true){
            String newtry = in.nextLine();
            if(newtry.equalsIgnoreCase(password)){
                System.out.printf("User %s logged in.",username);
                break;
            }else if(!newtry.equalsIgnoreCase(password) && count<3){
                System.out.println("Incorrect password. Try again.");
            }else{
                System.out.printf("User %s blocked!",username);
                break;
            }

            count++;
        }
    }
}
