package exercises.Find_Employees_by_First_Name;

import controller.DBConnector;
import entities.Employee;
import include.ExercisesInterface;

import javax.persistence.EntityManager;
import java.util.List;
import java.util.Scanner;

import static messages.ExerciseMessages.INSERT_INPUT;
import static messages.ExerciseMessages.SEPARATOR;

public class Main implements ExercisesInterface {
    private EntityManager em;
    private List<Employee> employeers;
    @Override
    public void run() {
        em = DBConnector.getEntityManager();
        fillEmployeers();

        System.out.println(SEPARATOR);

        for (Employee employeer : employeers) {
            System.out.printf("%s %s - %s - ($%s)\n",employeer.getFirstName(),employeer.getLastName(),employeer.getJobTitle(),employeer.getSalary());
        }


    }

    private void fillEmployeers() {
        System.out.println(INSERT_INPUT);
        String input = new Scanner(System.in).nextLine();

        employeers = em.createQuery("SELECT e FROM Employee e WHERE substring(e.firstName,1,:position) = :expected",Employee.class)
                .setParameter("position",input.length())
                .setParameter("expected",input)
                .getResultList();
    }
}
