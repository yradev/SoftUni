package exercises.Increase_Salaries;

import controller.DBConnector;
import entities.Employee;
import include.ExercisesInterface;

import javax.persistence.EntityManager;
import java.math.BigDecimal;
import java.util.List;
import static messages.ExerciseMessages.*;

public class Main implements ExercisesInterface {
    private EntityManager em;
    private List<Employee> employeeList;
    @Override
    public void run() {
        em = DBConnector.getEntityManager();
        fillEmployeeList();
        increaseSalary();
        System.out.println(SEPARATOR);
        printResult();
        System.out.println(SEPARATOR);
    }

    private void increaseSalary() {
        BigDecimal percent = new BigDecimal("1.12");
        em.getTransaction().begin();
        employeeList.forEach(a->{
            a.setSalary(a.getSalary().multiply(percent));
        });
        em.getTransaction().commit();
    }

    private void printResult() {
        employeeList.forEach(a->System.out.printf("%s %s - ($%s)\n",a.getFirstName(),a.getLastName(),a.getSalary()));
    }

    private void fillEmployeeList() {
        employeeList = em.createQuery("SELECT e FROM Employee e WHERE e.department.name IN ('Engineering','Tool Design','Marketing','Information Services') ",Employee.class).getResultList();
    }
}
