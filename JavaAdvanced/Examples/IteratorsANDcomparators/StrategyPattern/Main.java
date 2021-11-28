package JavaAdvanced.Examples.IteratorsANDcomparators.StrategyPattern;

import java.util.*;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        TreeSet<Person>Set1 = new TreeSet<>(new FirstCompirator());
        TreeSet<Person>Set2 = new TreeSet<>(new SecondComparator());

        int n=Integer.parseInt(scanner.nextLine());
        while(n-->0){
            List<String>Input = Arrays.stream(scanner.nextLine().split(" ")).collect(Collectors.toList());
            Person person = new Person(Input.get(0),Integer.parseInt(Input.get(1)));
            Set1.add(person);
            Set2.add(person);
        }

        Set1.forEach(System.out::println);
        Set2.forEach(System.out::println);
    }
}
