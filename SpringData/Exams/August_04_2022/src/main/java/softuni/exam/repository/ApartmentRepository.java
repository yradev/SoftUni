package softuni.exam.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import softuni.exam.models.entity.Apartment;
import softuni.exam.models.entity.Town;

// TODO:
@Repository
public interface ApartmentRepository extends JpaRepository<Apartment,Long> {
    @Query("SELECT a FROM Apartment a " +
            "WHERE a.town.townName = :townName AND a.area = :area")
    Apartment findApartmentByTownAndArea(String townName, double area);
}
