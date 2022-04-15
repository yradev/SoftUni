package exercises.Employees_Maximum_Salaries;

import controller.DBConnector;
import entities.Department;
import entities.Employee;
import include.ExercisesInterface;

import javax.persistence.EntityManager;
import java.util.Collection;
import java.util.Comparator;
import java.util.List;
import java.util.SortedMap;
import java.util.stream.Collectors;

import static messages.ExerciseMessages.SEPARATOR;

public class Main implements ExercisesInterface {
    private EntityManager em;
    private List<Employee> employees;

    @Override
    public void run() {
        em = DBConnector.getEntityManager();

        fillEmployees();

        System.out.println(SEPARATOR);
        employees.forEach(a->System.out.printf("%s  %s\n",a.getDepartment().getName(),a.getSalary()));
        System.out.println(SEPARATOR);
    }

    private void fillEmployees() {
      employees =  em.createQuery("" +
              "SELECT e " +
              "FROM Employee e " +
              "WHERE e.salary NOT BETWEEN 30000 AND 70000 AND e.salary IN ((SELECT MAX(e.salary) FROM Employee e GROUP BY e.department.name))" +
              "GROUP BY e.department.name ", Employee.class).getResultList();
    }
}
