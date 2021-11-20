package IteratorsANDcomparators.ComparingObjects;

import java.util.Comparator;

public class Comparing implements Comparator<Person> {

    @Override
    public int compare(Person This, Person Other) {
        int Compared=This.getName().compareTo(Other.getName());
        if(Compared==0){
            Compared=Integer.compare(This.getAge(),Other.getAge());
        }
        if(Compared==0){
            Compared=This.getTown().compareTo(Other.getTown());
        }
        return Compared;
    }
}
