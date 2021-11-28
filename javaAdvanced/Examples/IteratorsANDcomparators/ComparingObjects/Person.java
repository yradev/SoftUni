package IteratorsANDcomparators.ComparingObjects;

public class Person {
    private String Name;
    private int Age;
    private String Town;

    public Person(String Name,int Age,String Town) {
        this.Name = Name;
        this.Age = Age;
        this.Town = Town;
    }

    public String getName() {
        return Name;
    }

    public int getAge() {
        return Age;
    }

    public String getTown() {
        return Town;
    }

    @Override
    public String toString(){
       return String.format("%s %s %s",Name,Age,Town);
    }
}
