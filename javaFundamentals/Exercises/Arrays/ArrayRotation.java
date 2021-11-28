package javaFundamentals.Exercises.Arrays;

import java.util.*;
import java.util.stream.Collectors;

public class ArrayRotation {
    public static void main(String[] args) {
        Scanner Input = new Scanner(System.in);
        List<Integer> Array = Arrays.stream(Input.nextLine().split(" ")).map(Integer::parseInt).collect(Collectors.toList());
        int InputIndex = Integer.parseInt(Input.nextLine());
        int Index=InputIndex;
        if(Array.size()>Index) {
            Index -= 1;
        }else{
            Index=Index-(Array.size())-1;
        }

        List<Integer>FinalArray = new ArrayList<>();
        if(InputIndex!=Array.size()){

            for(int i=Index+1; i<=Array.size()-1; i++){
                FinalArray.add(Array.get(i));
            }

            for(int i=0; i<=Index; i++){
                FinalArray.add(Array.get(i));
            }
            String ToString = FinalArray.stream().map(String::valueOf).collect(Collectors.joining(" "));
            System.out.println(ToString);

        }else{
            String ToString = Array.stream().map(String::valueOf).collect(Collectors.joining(" "));
            System.out.println(ToString);
        }
    }
}
