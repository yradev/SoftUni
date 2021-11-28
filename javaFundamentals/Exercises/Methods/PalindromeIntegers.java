package javaFundamentals.Exercises.Methods;

import java.util.*;

public class PalindromeIntegers {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        while (true) {
            String LookingForEnd = in.nextLine();
            if (LookingForEnd.equalsIgnoreCase("end")) {
                break;
            }

            List<Integer> numbers = new ArrayList<>();
            List<Integer> GetNum1 = new ArrayList<>();
            List<Integer> GetNum2 = new ArrayList<>();

            GetNumbers(LookingForEnd, numbers);
            SaveNumbers(numbers, GetNum1, GetNum2);

            boolean result=true;
            for(int i=0; i<=GetNum1.size()-1; i++){
                if(GetNum1.get(i)!=GetNum2.get(i)){
                    result=false;
                }
            }

            System.out.println(result);

        }
    }

    public static void SaveNumbers(List<Integer> numbers, List<Integer> getNum1, List<Integer> getNum2) {
        for (int i = 0; i <= (numbers.size() - 1) / 2; i++) {
            getNum1.add(numbers.get(i));
        }
        if (numbers.size() % 2 != 0) {
            for (int b = numbers.size() - 1; b >= (numbers.size() - 1) / 2; b--) {
                getNum2.add(numbers.get(b));
            }
        } else {
            for (int b = numbers.size() - 1; b > (numbers.size() - 1) / 2; b--) {
                getNum2.add(numbers.get(b));
            }
        }
    }
    public static void GetNumbers(String lookingForEnd, List<Integer> numbers) {
        for(int i = 0; i<= lookingForEnd.length()-1; i++){
            numbers.add(lookingForEnd.charAt(i)-48);
        }
    }
}
