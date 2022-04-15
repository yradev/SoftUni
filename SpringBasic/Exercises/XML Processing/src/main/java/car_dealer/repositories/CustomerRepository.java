package car_dealer.repositories;

import car_dealer.entities.customers.Customer;
import car_dealer.entities.customers.CustomerTotalSales;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CustomerRepository  extends JpaRepository<Customer,Integer> {

    @Query("SELECT a FROM Customer a ORDER BY a.birthDate ASC,a.isYoungDriver")
    List<Customer> findAllCustomersOrderByBirthDateThanByIsYoungDriver();

    @Query("SELECT new car_dealer.entities.customers.CustomerTotalSales(c.name,c.sales.size,SUM(p.price)) " +
            "FROM Customer c " +
            "JOIN c.sales s " +
            "JOIN s.car car " +
            "JOIN car.parts p " +
            "GROUP BY c.name")
    List<CustomerTotalSales> findAllCustomersWithTotalSales();
}
