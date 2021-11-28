package DefiningClasses.CompanyRoster;

import java.util.ArrayList;
import java.util.List;

public class Department {
private List<Employee>ListOfEmployers;
private String Name;

public Department(String Name){
    this.Name=Name;
    ListOfEmployers = new ArrayList<>();
}
    public List<Employee>getEmployees(){
        return ListOfEmployers;
    }

    public double CalculateAverageSalary(){
    return this.ListOfEmployers.stream().mapToDouble(Employee::getSalary).average().orElse(0.0);
    }

@Override
    public String toString(){
        return Name;
    }
}
