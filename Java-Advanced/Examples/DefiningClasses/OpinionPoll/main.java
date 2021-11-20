package DefiningClasses.OpinionPoll;

import java.util.*;
import java.util.stream.Collectors;

public class main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        Person person = new Person();
        while(n-->0){
            List<String>Input = Arrays.stream(scanner.nextLine().split(" ")).collect(Collectors.toList());
            String Name = Input.get(0);
            int Age = Integer.parseInt(Input.get(1));
            person.setPerson(Name,Age);
        }

        person.getPersonsMoreThan30();
    }
}
