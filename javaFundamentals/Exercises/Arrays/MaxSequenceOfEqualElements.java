package javaFundamentals.Exercises.Arrays;

import java.util.*;

public class MaxSequenceOfEqualElements {
    public static void main(String[] args) {
        Scanner Input = new Scanner(System.in);
        String ArrayInput = Input.nextLine();

        String[] ArrayString = ArrayInput.split(" ");
        int[] Array = Arrays.stream(ArrayString)
                .mapToInt(Integer::parseInt).toArray();
        int count = 0;
        int number = Array[0];

        int SavedIndex = 0;
        int SavedNumber = 0;
        for (int i = 0; i <= Array.length - 1; i++) {
            if (Array[i] == number) {
                count++;
            } else {
                count = 1;
                number = Array[i];
            }
            if (count > SavedIndex) {
                SavedIndex = count;
                SavedNumber = Array[i];
            }
        }

        for (int i = 1; i <= SavedIndex; i++) {
            System.out.printf("%s ", SavedNumber);
        }
    }
}
