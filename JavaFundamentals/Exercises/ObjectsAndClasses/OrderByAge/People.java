package JavaFundamentals.Exercises.ObjectsAndClasses.OrderByAge;

public class People {
    private String Name;
    private int ID;
    private int age;

    public People(String Name,int ID,int age){
        this.Name=Name;
        this.ID=ID;
        this.age=age;
    }

    public int getAge(){
        return age;
    }

    public String getName() {
        return Name;
    }

    public int getID() {
        return ID;
    }

    @Override
    public String toString(){
        return String.format("%s with ID: %s is %s years old.",getName(),getID(),getAge());
    }
}
