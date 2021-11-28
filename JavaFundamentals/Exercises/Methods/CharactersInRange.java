package JavaFundamentals.Exercises.Methods;

import java.util.*;

public class CharactersInRange {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String char1input = in.nextLine();
        String char2input = in.nextLine();

        int char1 = char1input.charAt(0);
        int char2 = char2input.charAt(0);
        if(char1<=char2) {
            getchar1(char1, char2);
        }else{
            getchar2(char1, char2);
        }
    }

    public static void getchar2(int char1, int char2) {
        for(int i=char2+1; i<char1; i++){
            System.out.printf("%s ",(char) i);
        }
    }

    public static void getchar1(int char1, int char2) {
        for(int i=char1+1; i<char2; i++){
            System.out.printf("%s ",(char) i);
        }
    }
}
