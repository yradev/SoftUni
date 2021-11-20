package FunctionalProgramming;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class PredicateForNames {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int MaxLength = Integer.parseInt(scanner.nextLine());
        List<String>Names = Arrays.stream(scanner.nextLine().split("\\s+")).collect(Collectors.toList());
        Function<Stream<String>,Stream<String>> reworkNames = a->a
                .filter(b->b.length()<=MaxLength);

        reworkNames.apply(Names.stream()).forEach(System.out::println);
    }
}
