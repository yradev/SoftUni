package FunctionalProgramming;

import java.util.*;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class ListOfPredicates {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Integer> Numbers = new ArrayList<>();
        int Number = Integer.parseInt(scanner.nextLine());
        for(int i=1;i<=Number;i++){
            Numbers.add(i);
        }

        Function<Stream<Integer>,String>Print = a->a.map(String::valueOf).collect(Collectors.joining(" "));

        List<Integer>DivisibleNumbers = Arrays.stream(scanner.nextLine().split(" ")).map(Integer::parseInt).collect(Collectors.toList());

        Predicate<Integer> isValid = a->{
            boolean Result = true;
            int Value = Integer.parseInt(String.valueOf(a));
            for (Integer divisibleNumber : DivisibleNumbers) {
                if(Value%divisibleNumber!=0){
                    Result=false;
                    break;
                }
            }
            return Result;
        };

        Numbers.removeIf(a->!isValid.test(a));
        System.out.println(Print.apply(Numbers.stream()));

    }
}
