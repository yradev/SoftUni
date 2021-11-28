package JavaAdvanced.Examples.DefiningClasses.OpinionPoll;

import java.util.LinkedHashMap;
import java.util.Map;

public class Person {
    private String Name;
    private int Age;
    private Map<String,Integer> PersonsMoreThan30 = new LinkedHashMap<>();

    public void setPerson(String Name,int Age){
        this.Name = Name;
        this.Age = Age;

        if(this.Age>30){
            PersonsMoreThan30.put(Name,Age);
        }

    }

    public void getPersonsMoreThan30(){
        PersonsMoreThan30.entrySet().stream()
                .sorted(Map.Entry.comparingByKey())
                .forEach(a-> System.out.printf("%s - %s\n",a.getKey(),a.getValue()));
    }
}
