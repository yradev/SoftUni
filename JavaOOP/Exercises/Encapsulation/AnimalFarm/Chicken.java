package JavaOOP.Exercises.Encapsulation.AnimalFarm;

public class Chicken {
    private String name;
    private int age;

    public Chicken(String name, int age) {
        setName(name);
        setAge(age);
    }

    private void setName(String name) {
        if(name.equals(" ") || name.equals("")){
            throw new IllegalStateException("Name cannot be empty.");
        }
        this.name = name;
    }

    private void setAge(int age) {
        if(age<0 || age>15){
            throw new IllegalStateException("Age should be between 0 and 15");
        }
        this.age = age;
    }

    private double calculateProductPerDay(){
        if(age>=0 && age <=5){
            return 2;
        } if(age >=6 && age<=11){
            return 1;
        }
        return 0.75;
    }

    public double productPerDay(){
        return calculateProductPerDay();
    }

    @Override
    public String toString(){
        return String.format("Chicken %s (age %s) can produce %.2f eggs per day",name,age,productPerDay());
    }
}
