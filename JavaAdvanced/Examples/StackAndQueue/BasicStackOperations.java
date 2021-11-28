package JavaAdvanced.Examples.StackAndQueue;

import java.util.*;
import java.util.stream.Collectors;

public class BasicStackOperations {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        List<Integer> Conditions = Arrays.stream(input.nextLine().split(" ")).map(Integer::parseInt).collect(Collectors.toList());
        int N = Conditions.get(0);
        int S = Conditions.get(1);
        int X = Conditions.get(2);

        List<Integer> NumbersSplit = Arrays.stream(input.nextLine().split(" ")).map(Integer::parseInt).collect(Collectors.toList());
        if (NumbersSplit.size() == N) {
            ArrayDeque<Integer> Numbers = new ArrayDeque<>();

            for (int i = 0; i < NumbersSplit.size(); i++) {
                Numbers.push(NumbersSplit.get(i));
            }

            for (int i = 0; i < S; i++) {
                Numbers.pop();
                if (Numbers.isEmpty()) {
                    System.out.println("0");
                    return;
                }
            }

            System.out.println(Numbers.contains(X) ? true : Collections.min(Numbers));
        }
    }
}