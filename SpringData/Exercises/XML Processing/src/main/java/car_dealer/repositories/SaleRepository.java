package car_dealer.repositories;

import car_dealer.entities.sales.Sale;
import car_dealer.entities.sales.SaleWithDiscount;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SaleRepository extends JpaRepository<Sale,Integer> {
}
