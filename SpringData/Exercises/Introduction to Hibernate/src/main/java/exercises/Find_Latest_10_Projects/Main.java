package exercises.Find_Latest_10_Projects;

import controller.DBConnector;
import entities.Project;
import include.ExercisesInterface;

import javax.persistence.EntityManager;
import java.util.Comparator;
import java.util.List;

public class Main implements ExercisesInterface {
    private EntityManager em;
    private List<Project> projects;
    @Override
    public void run() {
        em = DBConnector.getEntityManager();

        projects = em.createQuery("SELECT p FROM Project p ORDER BY p.startDate DESC",Project.class).setMaxResults(10).getResultList();

        projects.stream().sorted(Comparator.comparing(Project::getName)).forEach(a->
                System.out.printf("Project name: %s\nProject Description: %s\nProject Start Date:%s\nProject End Date: %s\n\n",a.getName(),a.getDescription(),a.getStartDate(),a.getEndDate())
        );
    }
}
