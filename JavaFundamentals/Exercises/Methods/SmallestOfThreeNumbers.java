package JavaFundamentals.Exercises.Methods;

import java.util.*;
public class SmallestOfThreeNumbers {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        List<Integer>minValue = new ArrayList<>();
        getMinValues(input, minValue);

        int min = minValue.stream()
                .mapToInt(Integer::intValue)
                .min()
                .getAsInt();

        System.out.println(min);
    }

    private static void getMinValues(Scanner input, List<Integer> minValue) {
        for(int i=0;i<3;i++){
            int num = Integer.parseInt(input.nextLine());
            minValue.add(num);
        }
    }
}
