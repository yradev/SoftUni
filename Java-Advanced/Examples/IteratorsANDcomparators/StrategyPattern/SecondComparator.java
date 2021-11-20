package IteratorsANDcomparators.StrategyPattern;

import java.util.Comparator;

public class SecondComparator implements Comparator<Person> {
    @Override
    public int compare(Person o1, Person o2) {
        int Compare=Integer.compare(o1.Age,o2.Age);
        return Compare;
    }
}
