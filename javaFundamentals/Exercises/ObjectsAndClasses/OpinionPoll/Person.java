package javaFundamentals.Exercises.ObjectsAndClasses.OpinionPoll;

public class Person {
    String Name;
    int Age;

    public Person(String Name,int Age){
        this.Name=Name;
        this.Age=Age;
    }

    @Override
    public String toString(){
        return Name + " - " + Age;
    }
}
