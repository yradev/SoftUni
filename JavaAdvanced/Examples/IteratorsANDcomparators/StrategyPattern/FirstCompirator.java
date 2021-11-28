package JavaAdvanced.Examples.IteratorsANDcomparators.StrategyPattern;

import java.util.Comparator;

public class FirstCompirator implements Comparator<Person> {
    @Override
    public int compare(Person o1, Person o2) {
        int compared = Integer.compare(o1.Name.length(),o2.Name.length());
        if(compared==0){
            compared=String.valueOf(o1.Name.charAt(0)).compareToIgnoreCase(String.valueOf(o2.Name.charAt(0)));
        }
        return compared;
    }
}
