package FunctionalProgramming;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class CustomMinFunction {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        TreeSet<Integer>Numbers = Arrays.stream(scanner.nextLine().split(" ")).map(Integer::parseInt).collect(Collectors.toCollection(TreeSet::new));

        Function<Stream<Integer>,Integer> getSum = a->a.findFirst().orElse(0);
        System.out.println(getSum.apply(Numbers.stream()));
    }
}
