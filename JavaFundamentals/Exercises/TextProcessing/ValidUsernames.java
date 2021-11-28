package JavaFundamentals.Exercises.TextProcessing;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class ValidUsernames {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        List<String>tempList = Arrays.stream(input.nextLine().split(", ")).collect(Collectors.toList());
        String regEx = "^[\\w\\d\\-]+$";
        Pattern pattern = Pattern.compile(regEx);
        for (String name : tempList) {
            Matcher matcher = pattern.matcher(name);
            while(matcher.find()){
                String namefound = matcher.group();
                if(namefound.length()>3 && namefound.length()<16){
                    System.out.println(namefound);
                }
            }
        }

    }
}
