package exercises.Remove_Towns;

import controller.DBConnector;
import entities.Address;
import entities.Employee;
import entities.Town;
import include.ExercisesInterface;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;

import java.util.List;
import java.util.Scanner;

import static messages.ExerciseMessages.*;

public class Main implements ExercisesInterface {
    private EntityManager em;
    private Town town;
    private List<Address> addresses;
    private int countOfDeletedAddresses;
    @Override
    public void run() {
        em = DBConnector.getEntityManager();
        getTown();
        getAddresses();
        updateEmployees();
        countOfDeletedAddresses = removeAddresses();
        removeTown();
        System.out.println(SEPARATOR);
        System.out.printf(REMOVE_ADRESSES,countOfDeletedAddresses,town.getName());
        System.out.println(SEPARATOR);

    }

    private void updateEmployees() {
        for (Address address : addresses) {
            List<Employee> employees = em.createQuery("SELECT e FROM Employee e WHERE e.address.id = :address_id", Employee.class)
                    .setParameter("address_id", address.getId())
                    .getResultList();

            em.getTransaction().begin();

            employees.forEach(a -> {
                a.setAddress(null);
                em.persist(a);
            });

            em.getTransaction().commit();
        }
    }

    private void getAddresses() {
        addresses = em.createQuery("SELECT a FROM Address a WHERE a.town.id = :town_id",Address.class)
                .setParameter("town_id",town.getId())
                .getResultList();
    }

    private int removeAddresses() {
        em.getTransaction().begin();

        int result = em.createQuery("DELETE FROM Address a WHERE a.town.id = :town_id")
                .setParameter("town_id",town.getId())
                .executeUpdate();

        em.getTransaction().commit();

    return result;
    }

    private void removeTown() {
        em.getTransaction().begin();
        em.remove(town);
        em.getTransaction().commit();
    }

    private void getTown() {
        System.out.print(INPUT_NAME);

        try {
            String name = new Scanner(System.in).nextLine();
            town = em.createQuery("SELECT t FROM Town t WHERE t.name = :townName", Town.class)
                    .setParameter("townName", name)
                    .getSingleResult();
        }catch (NoResultException e){
            System.out.println(NO_TOWN);
        }
    }
}
