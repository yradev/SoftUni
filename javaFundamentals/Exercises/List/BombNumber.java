package javaFundamentals.Exercises.List;

import java.util.*;
import java.util.stream.Collectors;

public class BombNumber {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        List<Integer> Numbers = Arrays.stream(input.nextLine().split(" ")).map(Integer::parseInt).collect(Collectors.toList());
        List<Integer> NumbersSpecial = Arrays.stream(input.nextLine().split(" ")).map(Integer::parseInt).collect(Collectors.toList());
        int SpecialNumber = NumbersSpecial.get(0);
        int PowerNumber = NumbersSpecial.get(1);
        int Minimum = Integer.MIN_VALUE;

        for (int i = 0; i < Numbers.size(); i++) {
            if (Numbers.get(i) == SpecialNumber) {
                Numbers.set(i,Minimum);
                for (int k = 0; k<PowerNumber; k++) {
                    if(i-1-k>=0) {
                        Numbers.set(i -1-k,Minimum);
                    }
                    if(i+1+k<Numbers.size())
                        Numbers.set(i +1+k,Minimum);
                }
            }
        }

        Numbers.removeIf(e->e==Minimum);

        int sum = Numbers.stream()
                .mapToInt(Integer::intValue)
                .sum();

        System.out.println(sum);
    }
}
