package JavaFundamentals.Exercises.Methods;

import java.util.*;

public class MiddleCharacters {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String Text = in.nextLine();

        String[] TextString = Text.split("");

        if (Text.length() % 2 != 0) {
            int number = GetMiddleOneWord(TextString);
            System.out.println(TextString[number]);
        } else {
            int[] number = GetMiddleTwoWord(TextString);

            System.out.printf("%s%s", TextString[number[0]], TextString[number[1]]);
        }
    }

    public static int[] GetMiddleTwoWord(String[] textString) {
        int[] number = new int[2];
        for (int i = 0; i <= ((textString.length - 1) / 2); i++) {
            if (i == (textString.length - 1) / 2) {
                number[0] = i;
                number[1] = i + 1;
            }
        }
        return number;
    }

    public static int GetMiddleOneWord(String[] textString) {
        int number = 0;
        for (int i = 0; i <= (textString.length - 1) / 2; i++) {
            if (i == (textString.length - 1) / 2) {
                number = i;
            }
        }
        return number;
    }
}