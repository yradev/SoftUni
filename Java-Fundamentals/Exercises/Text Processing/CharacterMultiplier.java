package TextProcessing;

import java.util.*;
import java.util.stream.Collectors;

public class CharacterMultiplier {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        List<String> Words = Arrays.stream(input.nextLine().split(" ")).collect(Collectors.toList());

        int SmallerLength = Math.min(Words.get(0).length(), Words.get(1).length());
        int BiggerLength = Math.max(Words.get(0).length(), Words.get(1).length());

        int TotalSum = 0;
        for (int i = 0; i <= SmallerLength - 1; i++) {
            char Charof1 = Words.get(0).charAt(i);
            char Charof2 = Words.get(1).charAt(i);
            TotalSum += Charof1 * Charof2;
        }

        if (SmallerLength != BiggerLength) {
            for (int i = SmallerLength; i <= BiggerLength - 1; i++) {
                if (Words.get(0).length() > Words.get(1).length()) {
                    char charof1 = Words.get(0).charAt(i);
                    TotalSum += charof1;
                } else {
                    char charof1 = Words.get(1).charAt(i);
                    TotalSum += charof1;
                }
            }
        }
        System.out.println(TotalSum);
    }

}