package exercises.Change_casing;

import controller.DBConnector;
import entities.Town;
import include.ExercisesInterface;

import javax.persistence.EntityManager;
import java.util.List;

import static messages.ExerciseMessages.DB_UPDATED;
import static messages.ExerciseMessages.SEPARATOR;

public class Main implements ExercisesInterface {
    private EntityManager em;
    private List<Town> Towns;

    @Override
    public void run() {
        em = DBConnector.getEntityManager();

        em.getTransaction().begin();

      Towns =  em.createQuery("SELECT t FROM Town t ",Town.class).getResultList();

      Towns.stream()
            .filter(a->a.getName().length()>5)
            .forEach(a->{
                a.setName(a.getName().toUpperCase());
                em.persist(a);
             }
            );

    em.getTransaction().commit();

        System.out.println(SEPARATOR);
        System.out.println(DB_UPDATED);
        System.out.println(SEPARATOR);

    }
}
