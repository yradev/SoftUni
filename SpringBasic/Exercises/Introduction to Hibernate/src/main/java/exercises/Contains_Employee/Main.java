package exercises.Contains_Employee;

import controller.DBConnector;
import include.ExercisesInterface;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import java.util.Scanner;
import entities.*;

import static messages.ExerciseMessages.*;

public class Main implements ExercisesInterface {
    private String firstName;
    private String lastName;
    private EntityManager em;

    @Override
    public void run() {
        em  = DBConnector.getEntityManager();

        fillFields();

        System.out.println(SEPARATOR);
        System.out.println(getEmployerResult()?"Yes":"No");
        System.out.println(SEPARATOR);

    }

    private boolean getEmployerResult() {
        try {
            em.contains(em.createQuery("SELECT e FROM Employee e WHERE e.firstName = :first_name AND e.lastName = :last_name", Employee.class)
                    .setParameter("first_name", firstName)
                    .setParameter("last_name", lastName)
                    .getSingleResult());
            return true;
        }catch (NoResultException e){
            return false;
        }
    }

    private void fillFields() {
        System.out.println(ENTER_EMPLOYEE_NAME);
        String input = new Scanner(System.in).nextLine();
        String[]Split = input.split(" ");
        firstName = Split[0];
        lastName = Split[1];
    }
}
