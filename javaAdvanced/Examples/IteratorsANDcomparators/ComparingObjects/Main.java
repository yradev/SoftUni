package IteratorsANDcomparators.ComparingObjects;
import java.util.*;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Persons persons = new Persons();
        while(true){
            List<String>Input = Arrays.stream(scanner.nextLine().split(" ")).collect(Collectors.toList());
            if(Input.get(0).equals("END")){
                break;
            }
            persons.Add(Input.get(0),Integer.parseInt(Input.get(1)),Input.get(2));
        }

        int PersonIndex = Integer.parseInt(scanner.nextLine())-1;
        persons.Compare();
        int Equals = 0;
        int NotEquals = 0;
        for (Person person : persons.personList) {
            if(persons.isEqual(persons.getPerson(PersonIndex),person)){
             Equals++;
            }else{
                NotEquals++;
            }
        }

        if(Equals>1) {
            System.out.printf("%s %s %s", Equals, NotEquals, persons.personList.size());
        }else{
            System.out.println("No matches");
        }


    }
}
