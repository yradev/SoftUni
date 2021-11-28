package JavaFundamentals.Exercises.TextProcessing;

import java.util.*;
import java.util.stream.Collectors;

public class LettersChangeNumbers {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        String alphabetLower = "abcdefghijklmnopqrstuvwxyz";
        String alphabetUpper = alphabetLower.toUpperCase();
        List<String>Input = Arrays.stream(input.nextLine().split("\\s+")).collect(Collectors.toList());
        double Total = 0;
        for (String value : Input) {
            String tempFirstChar = String.valueOf(value.charAt(0));
            String tempLastChar = String.valueOf(value.charAt(value.length()-1));
            int NumbersInside = Integer.parseInt(value.substring(1,value.length()-1));

            double tempValue = 0;
            if(alphabetLower.contains(tempFirstChar)){
                int tempIndex=alphabetLower.indexOf(tempFirstChar)+1;
                tempValue+=NumbersInside*(double)tempIndex;
            }else if(alphabetUpper.contains(tempFirstChar)){
                int tempIndex=alphabetUpper.indexOf(tempFirstChar)+1;
                tempValue+=NumbersInside/(double)tempIndex;
            }

            if(alphabetLower.contains(tempLastChar)){
                int tempIndex=alphabetLower.indexOf(tempLastChar)+1;
                Total+=tempValue+tempIndex;
            }else if(alphabetUpper.contains(tempLastChar)){
                int tempIndex=alphabetUpper.indexOf(tempLastChar)+1;
                Total+=tempValue-tempIndex;
            }
        }
        System.out.printf("%.2f",Total);
    }
}
