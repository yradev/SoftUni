package Exams.Octomber232021.hotel;

import java.util.ArrayList;
import java.util.List;

public class Hotel {
private String name;
private int capacity;
private List<Person> roster;

    public Hotel(String name, int capacity) {
        this.name = name;
        this.capacity = capacity;
        roster = new ArrayList<>();
    }

    public void add(Person person){
        if(roster.size()<capacity){
            roster.add(person);
        }
    }

    public boolean remove(String name){
        for (Person person : roster) {
            if(person.getName().equals(name)){
                roster.remove(person);
                return true;
            }
        }

        return false;
    }

    public Person getPerson(String name, String hometown){
        for (Person person : roster) {
            if(person.getName().equals(name) && person.getHometown().equals(hometown)){
                return person;
            }
        }
        return null;
    }

    public int getCount(){
        return roster.size();
    }

    public String getStatistics(){
        StringBuilder toPrint = new StringBuilder();
        toPrint.append(String.format("The people in the hotel %s are:",name)).append(System.lineSeparator());
        for (Person person : roster) {
            toPrint.append(person).append(System.lineSeparator());
        }

        return toPrint.toString();
    }
}
