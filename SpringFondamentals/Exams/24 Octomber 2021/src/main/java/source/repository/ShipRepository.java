package source.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import source.model.dto.ShipViewDTO;
import source.model.entity.Ship;

public interface ShipRepository extends JpaRepository<Ship,Long> {
    Ship findByName(String name);
}
