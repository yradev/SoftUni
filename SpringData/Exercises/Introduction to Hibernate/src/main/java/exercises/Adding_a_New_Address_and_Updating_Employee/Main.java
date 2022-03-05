package exercises.Adding_a_New_Address_and_Updating_Employee;

import controller.DBConnector;
import entities.Address;
import entities.Employee;
import include.ExercisesInterface;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;

import java.util.List;
import java.util.Scanner;

import static messages.ExerciseMessages.*;

public class Main implements ExercisesInterface {
    private EntityManager em;
    private Address address;
    @Override
    public void run() {
        em = DBConnector.getEntityManager();
        importAddress();
        setAddressToEmployee();
    }

    private void setAddressToEmployee() {
        try{
            System.out.println(ENTER_LASTNAME);
            String lastName = new Scanner(System.in).nextLine();
          List<Employee> employee = em.createQuery("SELECT e FROM Employee e WHERE e.lastName= :last_name",Employee.class)
                    .setParameter("last_name",lastName)
                            .getResultList();

            em.getTransaction().begin();

            employee.forEach(a->{
                a.setAddress(address);
                em.persist(a);
            });
            em.getTransaction().commit();
            System.out.println(SEPARATOR);
            System.out.println(EMPLOYEES_UPDATED);
            System.out.println(SEPARATOR);

        }catch (NoResultException e){
            System.out.println(NO_EMPLOYEE);
        }
    }

    private void importAddress() {
        try {
          address = em.createQuery("SELECT a FROM Address a WHERE a.text='Vitoshka 15'",Address.class).getSingleResult();
            System.out.println(ADDRESS_EXIST);
        }catch (NoResultException e){
            address = new Address();
            address.setText("Vitoshka 15");
            em.getTransaction().begin();
            em.persist(address);
            em.getTransaction().commit();
        }
    }
}
