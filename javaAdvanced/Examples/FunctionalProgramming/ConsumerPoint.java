package FunctionalProgramming;

import java.util.*;
import java.util.function.Consumer;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class ConsumerPoint {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<String> Strings = Arrays.stream(scanner.nextLine().split(" ")).collect(Collectors.toList());
        Consumer<Stream<String>>Printer = a->a.forEach(System.out::println);
        Printer.accept(Strings.stream());
    }
}
