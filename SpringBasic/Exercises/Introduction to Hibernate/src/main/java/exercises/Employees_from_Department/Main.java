package exercises.Employees_from_Department;

import controller.DBConnector;
import entities.Department;
import entities.Employee;
import include.ExercisesInterface;

import javax.persistence.EntityManager;
import java.util.List;

import static messages.ExerciseMessages.*;

public class Main implements ExercisesInterface {
    private EntityManager em;
    private List<Employee> employees;
    @Override
    public void run() {
        em = DBConnector.getEntityManager();
        fillEmployees();

        System.out.println(SEPARATOR);
        printResult();
        System.out.println(SEPARATOR);
    }

    private void printResult() {
        employees.forEach(a->System.out.printf("%s %s from %s - $%s\n",a.getFirstName(),a.getLastName(),a.getDepartment().getName(),a.getSalary()));
    }

    private void fillEmployees() {
        employees = em.createQuery("SELECT e from Employee e WHERE e.department.name = 'Research and Development' ORDER BY e.salary ASC, e.id ASC",Employee.class)
                .getResultList();
    }
}
