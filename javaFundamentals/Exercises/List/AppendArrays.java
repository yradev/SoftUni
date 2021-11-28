package javaFundamentals.Exercises.List;

import java.util.*;
import java.util.stream.Collectors;

public class AppendArrays {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        List<String> NumbersInput = Arrays.stream(input.nextLine().split("\\|")).collect(Collectors.toList());
        List<String> NumbersArray = new ArrayList<>();

        for(int i=NumbersInput.size()-1;i>=0;i--){
            String [] tempOldArray = NumbersInput.get(i).split("\\s+");
            for (int a=0;a<=tempOldArray.length-1;a++) {
                if (!tempOldArray[a].equals("")) {
                    NumbersArray.add(tempOldArray[a]);
                }
            }
        }

        String EndString = String.join(" ",NumbersArray);
        System.out.println(EndString);
    }
}
