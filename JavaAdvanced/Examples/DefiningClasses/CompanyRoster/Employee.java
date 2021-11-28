package JavaAdvanced.Examples.DefiningClasses.CompanyRoster;

public class Employee {
    private String Name;
    private double Salary;
    private String Position;
    private String department;
    private String Email;
    private int Age;

    public Employee(String Name,double Salary, String Position, String department, String Email,int Age) {
        this.Name = Name;
        this.Salary = Salary;
        this.Position = Position;
        this.department = department;
        this.Email = Email;
        this.Age = Age;
    }

    public double getSalary() {
        return Salary;
    }

    @Override
    public String toString() {
        return String.format("%s %.2f %s %d", this.Name, this.Salary,this.Email, this.Age);
    }
}
