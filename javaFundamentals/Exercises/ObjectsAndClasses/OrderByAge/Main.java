package javaFundamentals.Exercises.ObjectsAndClasses.OrderByAge;
import java.util.*;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        List <People> people = new ArrayList<>();
        String Input = input.nextLine();
        while(!Input.equalsIgnoreCase("end")) {
            List<String> Split = Arrays.stream(Input.split(" ")).collect(Collectors.toList());
            String Name = Split.get(0);
            int ID = Integer.parseInt(Split.get(1));
            int Age = Integer.parseInt(Split.get(2));

            People NewMan = new People(Name, ID, Age);
            people.add(NewMan);
            Input = input.nextLine();
        }

        people.stream()
                .sorted(Comparator.comparing(People::getAge))
                .forEach(System.out::println);
    }
    }
