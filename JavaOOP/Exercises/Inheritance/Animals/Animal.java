package JavaOOP.Exercises.Inheritance.Animals;

public class Animal {
    private String name;
    private int age;
    private String gender;

    public Animal(String name, int age, String gender) {
        setName(name);
        setAge(age);
        setGender(gender);
    }

    public void setName(String name) {
        if(name.trim().isEmpty()){
            throw new IllegalStateException("Invalid input!");
        }
        this.name = name;
    }

    public void setAge(int age) {
        if(age==' ' || age<=0){
            throw new IllegalStateException("Invalid input!");
        }
        this.age = age;
    }

    public void setGender(String gender) {
        if(gender.trim().isEmpty()){
            throw new IllegalStateException("Invalid input!");
        }
        this.gender = gender;
    }

    public String produceSound(){
        return "Animal";
    }

    @Override
    public String toString(){
        return String.format("%s\n%s %s %s\n%s",this.getClass().getSimpleName(),name,age,gender,produceSound());
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public String getGender() {
        return gender;
    }
}
