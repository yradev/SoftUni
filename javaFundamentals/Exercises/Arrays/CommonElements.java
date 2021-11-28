package javaFundamentals.Exercises.Arrays;

import java.util.*;
import java.util.stream.Collectors;

public class CommonElements {
    public static void main(String[] args) {
        Scanner Input = new Scanner(System.in);
        List <String> Array1 = Arrays.stream(Input.nextLine().split(" ")).collect(Collectors.toList());
        List <String> Array2 = Arrays.stream(Input.nextLine().split(" ")).collect(Collectors.toList());

        for (String s : Array1) {
            if(Array2.contains(s)){
                System.out.printf("%s ",s);
            }
        }

    }
}
