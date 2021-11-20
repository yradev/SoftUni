package FunctionalProgramming;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class ReverseAndExclude {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Integer>ListOfNumbers = Arrays.stream(scanner.nextLine().split(" ")).map(Integer::parseInt).collect(Collectors.toList());
        int n = Integer.parseInt(scanner.nextLine());
        Collections.reverse(ListOfNumbers);
        Function<Stream<Integer>,String>reworkList = a->a
                .filter(b->b%n!=0)
                .map(String::valueOf)
                .collect(Collectors.joining(" "));
        System.out.println(reworkList.apply(ListOfNumbers.stream()));
    }
}
