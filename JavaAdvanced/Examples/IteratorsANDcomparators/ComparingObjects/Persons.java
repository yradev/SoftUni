package JavaAdvanced.Examples.IteratorsANDcomparators.ComparingObjects;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Persons {
    List<Person> personList;

    public Persons() {
        personList = new ArrayList<>();
    }

    public void Add(String Name, int Age, String Town) {
        Person person = new Person(Name, Age, Town);
        personList.add(person);
    }

    public Person getPerson(int number){
        return personList.get(number);
    }

    public boolean isEqual(Person This, Person Other){
        return This.getName().equals(Other.getName()) && This.getAge() == Other.getAge() && This.getTown().equals(Other.getTown());
    }

    public void Compare(){
      personList =  personList.stream().sorted(new Comparing()).collect(Collectors.toList());
    }

    public List<Person> getPersonList() {
        return personList;
    }
}
