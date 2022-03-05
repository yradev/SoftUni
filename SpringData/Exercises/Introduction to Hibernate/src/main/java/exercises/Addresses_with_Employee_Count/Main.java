package exercises.Addresses_with_Employee_Count;

import controller.DBConnector;
import entities.Address;
import include.ExercisesInterface;

import javax.persistence.EntityManager;
import java.util.ArrayList;
import java.util.List;

import static messages.ExerciseMessages.SEPARATOR;


public class Main implements ExercisesInterface {
    private EntityManager em;
    private List<String>Printer;

    @Override
    public void run() {
        em = DBConnector.getEntityManager();
        setAddresses();
        System.out.println(SEPARATOR);
        Printer.forEach(System.out::println);
        System.out.println(SEPARATOR);

    }

    private void setAddresses() {
        List<Address> addressList = em.createQuery("SELECT a FROM Address a ORDER by a.employees.size DESC",Address.class)
                .setMaxResults(10)
                .getResultList();

        Printer = new ArrayList<>();
        addressList.forEach(a->Printer.add(a.getText()+" "+a.getTown().getName() + " - " + a.getEmployees().size() + " exercises"));

    }
}
