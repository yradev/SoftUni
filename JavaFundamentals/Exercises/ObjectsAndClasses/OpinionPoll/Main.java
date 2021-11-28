package JavaFundamentals.Exercises.ObjectsAndClasses.OpinionPoll;
import java.util.*;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
       List<Person> Poll = new ArrayList<>();

        int n=Integer.parseInt(input.nextLine());
        for(int i=1;i<=n;i++){
            List<String>Values = Arrays.stream(input.nextLine().split(" ")).collect(Collectors.toList());;
            String name = Values.get(0);
            int Age = Integer.parseInt(Values.get(1));

            if(Age>30){
                Person person = new Person(name,Age);
                Poll.add(person);
            }
        }
        List<Person>Sorted = Poll.stream()
                .sorted(Comparator.comparing(a -> a.Name))
                .collect(Collectors.toList());

        for (Person person : Sorted) {
            System.out.println(person);
        }

    }
}
