package Method;

import java.util.*;

public class PasswordValidator {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String password = in.nextLine();


        if (PasswordCheckLength(password) && PasswordCheck2Digits(password) && isPasswordCheckNumbersAndDigits(password)) {
            System.out.println("Password is valid");
        }

        if(!PasswordCheckLength(password)){
            System.out.println("Password must be between 6 and 10 characters");
        }

        if (!isPasswordCheckNumbersAndDigits(password)) {
            System.out.println("Password must consist only of letters and digits");
        }

        if (!PasswordCheck2Digits(password)) {
            System.out.println("Password must have at least 2 digits");
        }
    }

    public static boolean isPasswordCheckNumbersAndDigits(String password) {
        String IsTrue = "";
        for (int i = 0; i <= password.length() - 1; i++) {
            int TakeCharNumber = password.charAt(i);
            if (TakeCharNumber >= 48 && TakeCharNumber <= 57 || TakeCharNumber >= 65 && TakeCharNumber <= 90 || TakeCharNumber >= 97 && TakeCharNumber <= 122) {
                IsTrue = "yes";
            } else {
                IsTrue= "no";
                break;
            }
        }
        if (IsTrue.equalsIgnoreCase("yes")) {
            return true;
        } else {
            return false;
        }
    }

    public static boolean PasswordCheck2Digits(String password) {
        int max=0;
        for(int i = 0; i<=password.length()-1; i++){
            int TakeCharNumbers=password.charAt(i);
            if(TakeCharNumbers>=48 && TakeCharNumbers<=57){
                max+=1;
            }
        }
        if(max>=2){
            return true;
        }else{
            return false;
        }
    }

    public static boolean PasswordCheckLength(String password){
        if (password.length() >= 6 && password.length() <= 10) {
            return true;
        } else {
            return false;
        }
    }
}
