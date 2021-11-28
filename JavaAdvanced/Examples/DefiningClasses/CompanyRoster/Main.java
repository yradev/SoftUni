package JavaAdvanced.Examples.DefiningClasses.CompanyRoster;

import java.util.*;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Map<String,Department> Departmants = new LinkedHashMap<>();

        int n = Integer.parseInt(scanner.nextLine());
        while(n-->0){
            List<String>Input = Arrays.stream(scanner.nextLine().split(" ")).collect(Collectors.toList());
            String Name = Input.get(0);
            double Salary = Double.parseDouble(Input.get(1));
            String Position = Input.get(2);
            String department = Input.get(3);
            Employee Employer = null;
            if(Input.size()==4){
                Employer=new Employee(Name,Salary,Position,department,"n/a",-1);
            }
            if(Input.size()==5){
                try{
                    int age = Integer.parseInt(Input.get(4));
                    Employer=new Employee(Name,Salary,Position,department,"n/a",age);
                }catch (NumberFormatException e){
                    String Email = Input.get(4);
                    Employer=new Employee(Name,Salary,Position,department,Email,-1);
                }
            }

            if(Input.size()==6){
                String Email = Input.get(4);
                int Age = Integer.parseInt(Input.get(5));
                Employer=new Employee(Name,Salary,Position,department,Email,Age);
            }
            Departmants.putIfAbsent(department,new Department(department));
            Departmants.get(department).getEmployees().add(Employer);
        }


        Department highestPaidDepartment = Departmants.entrySet().stream()
                .max(Comparator.comparing(a->a.getValue().CalculateAverageSalary()))
                .get()
                .getValue();

        System.out.printf("Highest Average Salary: %s\n",highestPaidDepartment);

        highestPaidDepartment.getEmployees().stream().sorted((a,b)->Double.compare(b.getSalary(),a.getSalary())).forEach(System.out::println);
    }
}
