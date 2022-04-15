package exam.repository;


import exam.model.town.Town;
import org.springframework.data.jpa.repository.JpaRepository;

//ToDo:
public interface TownRepository extends JpaRepository<Town,Integer> {
    Town findTownByName(String name);
}
