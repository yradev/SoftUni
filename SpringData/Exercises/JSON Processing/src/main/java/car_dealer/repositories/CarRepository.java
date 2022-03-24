package car_dealer.repositories;

import car_dealer.entities.cars.Car;
import car_dealer.entities.cars.CarsFromToyotaDTO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CarRepository extends JpaRepository<Car,Integer> {

    @Query("SELECT new car_dealer.entities.cars.CarsFromToyotaDTO(a.id,a.make,a.model,a.travelledDistance) " +
            "FROM Car a " +
            "WHERE a.make = 'Toyota'" +
            " ORDER BY a.model ASC,a.travelledDistance DESC")
    List<CarsFromToyotaDTO> findCarsFromToyota();
}
