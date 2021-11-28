package JavaAdvanced.Exams.December162020.bakery;

import java.util.ArrayList;
import java.util.List;

public class Bakery {
    private String name;
    private int capacity;
    private List<Employee> employees;

    public Bakery(String name, int capacity) {
        this.name = name;
        this.capacity = capacity;
        employees = new ArrayList<>();
    }

    public void add(Employee employee){
        if(employees.size()<capacity){
            employees.add(employee);
        }
    }

    public boolean remove(String name){
        for (Employee employee : employees) {
            if(employee.getName().equals(name)){
                employees.remove(employee);
                return true;
            }
        }
        return false;
    }

    public Employee getOldestEmployee(){
            return employees.stream().sorted((a, b) -> Integer.compare(b.getAge(), a.getAge())).findFirst().get();

    }

    public Employee getEmployee(String name){
        Employee returnEmployee = null;
        for (Employee employee : employees) {
            if(employee.getName().equals(name)){
                returnEmployee = employee;
            }
        }
        return returnEmployee;
    }

    public int getCount(){
        return employees.size();
    }

    public String report(){
        StringBuilder toPrint = new StringBuilder();

        toPrint.append(String.format("Employees working at Bakery %s:",name)).append(System.lineSeparator());
        for (Employee employee : employees) {
            toPrint.append(employee).append(System.lineSeparator());
        }

        return toPrint.toString();
    }
}
