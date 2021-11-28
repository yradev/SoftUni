package javaFundamentals.Exercises.Arrays;

import java.util.*;
import java.util.stream.Collectors;

public class KaminoFactory {
    public static void main(String[] args) {
        Scanner Input = new Scanner(System.in);
        int Length = Integer.parseInt(Input.nextLine());
        int Count  = 0;
        int SavedArrayLength  = 0;
        int Sum = 0;
        int SavedStartIndex  = Length;
        int ArrayPosition = 0;
        int[] SavedArray = new int[Length];
        String input = Input.nextLine();
        while (!input.equalsIgnoreCase("clone them!")) {
            Count++;
            int[] DNA = Arrays.stream(input.split("!+")).mapToInt(Integer::parseInt).toArray();
            int tempSum = 0;
            int tempArrayLength=0;
            int tempStartIndex=0;
            int CountArrayLength = 0;

            for (int k = 0; k < Length; k++) {
                if (DNA[k] == 1) {
                    tempSum++;
                }
            }

            for (int i = Length-1; i >= 0; i--) {
                if(DNA[i]==1) {
                    CountArrayLength++;
                    if (CountArrayLength > tempArrayLength  ) {
                        tempArrayLength = CountArrayLength;
                        tempStartIndex = i;
                    }
                }else {
                    CountArrayLength = 0;
                }
            }

            if (tempArrayLength > SavedArrayLength ) {
                SavedArrayLength  = tempArrayLength;
                SavedStartIndex  = tempStartIndex;
                ArrayPosition = Count ;
                SavedArray = DNA;
                Sum = tempSum;
            }else if (tempArrayLength == SavedArrayLength  && SavedStartIndex > tempStartIndex ) {
                SavedStartIndex  = tempStartIndex;
                ArrayPosition = Count ;
                SavedArray = DNA;
                Sum = tempSum;
            }else if (tempArrayLength == SavedArrayLength  && tempStartIndex == SavedStartIndex  && tempSum > Sum) {
                ArrayPosition = Count ;
                SavedArray = DNA;
                Sum = tempSum;
            }

            input = Input.nextLine();
        }
        String EndString = Arrays.stream(SavedArray)
                .mapToObj(String::valueOf)
                .collect(Collectors.joining(" "));

        System.out.printf("Best DNA sample %s with sum: %s.\n%s",ArrayPosition,Sum,EndString);
    }
}
