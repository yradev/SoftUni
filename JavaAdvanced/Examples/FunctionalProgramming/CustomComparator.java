package JavaAdvanced.Examples.FunctionalProgramming;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class CustomComparator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Integer>Integers = Arrays.stream(scanner.nextLine().split(" ")).map(Integer::parseInt).collect(Collectors.toList());

        Function<Stream<Integer>,String> Reworking = a->a
                .sorted((b,c)->{
                    int Value1 = Math.abs(b)%2;
                    int Value2 = Math.abs(c)%2;
                    int Result = Integer.compare(Value1,Value2);
                    if(Result==0){
                        Result=b.compareTo(c);
                    }
                    return Result;
        })
                .map(String::valueOf)
                .collect(Collectors.joining(" "));

        System.out.println(Reworking.apply(Integers.stream()));
    }

}
