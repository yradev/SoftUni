package exercises.Employees_with_Salary_Over_50000;

import controller.DBConnector;
import entities.Employee;
import include.ExercisesInterface;
import static messages.ExerciseMessages.*;


import javax.persistence.EntityManager;
import java.util.List;

public class Main implements ExercisesInterface {
    private List<Employee>employees;
    private EntityManager em;
    @Override
    public void run() {
        em = DBConnector.getEntityManager();
        fillEmployee();
        System.out.println(SEPARATOR);
        printEmployees();
        System.out.println(SEPARATOR);
    }

    private void printEmployees() {
        employees.forEach(a-> System.out.println(a.getFirstName()));
    }

    private void fillEmployee() {
        employees =  em.createQuery("SELECT e FROM Employee e WHERE e.salary>50000",Employee.class).getResultList();
    }
}
