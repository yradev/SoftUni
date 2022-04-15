package exam.repository;

import exam.model.laptop.Laptop;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

//ToDo:
@Repository
public interface LaptopRepository extends JpaRepository<Laptop,Integer> {
    Laptop findLaptopByMacAddress(String macAddress);

    @Query("SELECT a FROM Laptop a " +
            "ORDER BY a.cpuSpeed DESC, a.ram DESC, a.storage DESC, a.macAddress ASC")
    List<Laptop> findBestLaptops();
}
