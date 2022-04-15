package game_store.Repositories;

import game_store.Entities.Game;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface GameRepository extends JpaRepository<Game,Integer> {
    List<Game>findGameById(int id);
    List<Game>findGamesByTitle(String title);
}
