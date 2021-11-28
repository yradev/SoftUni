package FunctionalProgramming;

import java.util.*;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class AppliedArithmetics {
    private static Object Stream;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Integer>Numbers = Arrays.stream(scanner.nextLine().split(" ")).map(Integer::parseInt).collect(Collectors.toList());
        Function<Stream<Integer>,Stream<Integer>> AddNumberByOne = a->a.map(Value ->Value+1);
        Function<Stream<Integer>,Stream<Integer>> MultiplyByTwo = a->a.map(Value ->Value*2);
        Function<Stream<Integer>,Stream<Integer>> SubtrackByOne = a->a.map(Value ->Value-1);

        Function<Stream<Integer>,String> Joiner = a->a.map(String::valueOf).collect(Collectors.joining(" "));
        while(true){
            String Command = scanner.nextLine();
            if(Command.equals("end")){
                break;
            }
            switch (Command){
                case"add":
                    Numbers = AddNumberByOne.apply(Numbers.stream()).collect(Collectors.toList());
                    break;
                case"multiply":
                    Numbers = MultiplyByTwo.apply(Numbers.stream()).collect(Collectors.toList());
                    break;
                case"subtract":
                    Numbers = SubtrackByOne.apply(Numbers.stream()).collect(Collectors.toList());
                    break;
                case"print":
                    System.out.println(Joiner.apply(Numbers.stream()));
                    break;
            }
        }
    }
}
