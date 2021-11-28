package JavaAdvanced.Examples.FunctionalProgramming;
import java.util.*;
import java.util.function.Consumer;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class KnightsOfHonor {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<String>Names = Arrays.stream(scanner.nextLine().split(" ")).collect(Collectors.toList());
        Consumer<Stream<String>> Printer = a->a.forEach(Name -> System.out.printf("Sir %s%n",Name));
        Printer.accept(Names.stream());
    }
}
