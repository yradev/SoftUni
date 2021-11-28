package javaFundamentals.Exercises.ObjectsAndClasses.Students;

public class Students {
    String FirstName;
    String LastName;
    double Grade;

    public Students(String FirstName, String LastName, double Grade){
        this.FirstName = FirstName;
        this.LastName = LastName;
        this.Grade = Grade;
    }
    @Override
    public String toString(){
        return String.format("%s %s: %.2f",FirstName,LastName,Grade);
    }
}
