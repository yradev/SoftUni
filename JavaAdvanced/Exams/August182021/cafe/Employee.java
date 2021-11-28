package JavaAdvanced.Exams.August182021.cafe;

public class Employee {
    private String name;
    private int age;
    private String country;

    public Employee(String Name,int Age,String Country){
        this.name = Name;
        this.age = Age;
        this.country = Country;
    }

    public int getAge() {
        return age;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString(){
       return String.format("Employee: %s, %s from %s",name,age, country);
    }
}
