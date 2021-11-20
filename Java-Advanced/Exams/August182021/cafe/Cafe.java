package Exams.August182021.cafe;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Cafe {
    private String name;
    private int capacity;
    private List<Employee> employees;

    public Cafe(String Name,int Capacity){
        this.name = Name;
        this.capacity = Capacity;
        employees = new ArrayList<>();
    }
    public void addEmployee(Employee employee){
        if (this.capacity > this.employees.size()) {
            employees.add(employee);
        }
    }

    public boolean removeEmployee(String employee){
        boolean isTrue = false;
        for (int i = 0; i< employees.size(); i++){
            if(employees.get(i).getName().equals(employee)){
                isTrue=true;
                employees.remove(i);
                break;
            }
        }
        return isTrue;
    }

    public Employee getOldestEmployee(){
        List<Employee> OldestEmployee = employees.stream().sorted((b, a)->Integer.compare(a.getAge(),b.getAge())).collect(Collectors.toList());
return  OldestEmployee.get(0);
    }

    public Employee getEmployee(String Name){
        List<Employee>NameSearcher = employees.stream().filter(a->a.getName().equals(Name)).collect(Collectors.toList());
        return NameSearcher.get(0);
    }

    public int getCount(){
        return employees.size();
    }

    public String report(){
        StringBuilder Report = new StringBuilder();
        Report.append(String.format("Employees working at Cafe %s:\n", name));
        for (Employee employer : employees) {
            Report.append(String.format("%s\n",employer));
        }

        return Report.toString();
    }
}
