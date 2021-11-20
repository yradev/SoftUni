package FunctionalProgramming;
import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class FindTheSmallestEllement {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Integer>ListOfIntegers = Arrays.stream(scanner.nextLine().split("\\s+")).map(Integer::parseInt).collect(Collectors.toList());
        Function<Stream<Integer>,Integer> getMin = a->a.mapToInt(Integer::intValue).min().orElse(-1);
        System.out.println(ListOfIntegers.lastIndexOf(getMin.apply(ListOfIntegers.stream())));
    }
}
