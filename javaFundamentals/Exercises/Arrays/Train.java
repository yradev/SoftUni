package Arrays;

import java.util.*;
import java.util.stream.Collectors;

public class Train {
    public static void main(String[] args) {
        Scanner Input = new Scanner(System.in);
        int Wagons = Integer.parseInt(Input.nextLine());
        List <Integer> Person = new ArrayList<>();

        for(int i=1;i<=Wagons;i++){
            int Persons = Integer.parseInt(Input.nextLine());
            Person.add(Persons);
        }

        int sum = Person.stream().mapToInt(Integer::intValue).sum();

        String nums = Person.stream()
                .map(String::valueOf)
                .collect(Collectors.joining(" "));
        System.out.printf("%s\n%s",nums,sum);
    }
}
