package exercises.Get_Employee_with_Project;

import controller.DBConnector;
import entities.Employee;
import entities.Project;
import include.ExercisesInterface;

import javax.persistence.EntityManager;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

import static messages.ExerciseMessages.*;

public class Main implements ExercisesInterface {
    private EntityManager em;
    private Employee employee;
    private List<String>projects;
    @Override
    public void run() {
        em = DBConnector.getEntityManager();
        fillEmployee();
        fillProjects();
        System.out.println(SEPARATOR);
        System.out.printf("%s %s - %s\n",employee.getFirstName(),employee.getLastName(),employee.getJobTitle());
        projects.forEach(System.out::println);
        System.out.println(SEPARATOR);

    }

    private void fillProjects() {
        projects = new ArrayList<>();
        employee.getProjects().stream().sorted(Comparator.comparing(Project::getName)).forEach(a->{
            projects.add(a.getName());
        });
    }

    private void fillEmployee() {
        System.out.println(ENTER_EMPLOYEE_ID);
        String input = new Scanner(System.in).nextLine();
       employee = em.find(Employee.class,Integer.parseInt(input));

        if(!em.contains(employee)){
            throw new IllegalArgumentException(INVALID_ID);
        }
    }
}
