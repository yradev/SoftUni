package game_store.Repositories;

import game_store.Entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {
    List<User> findUsersByEmail(String email);
    List<User> findUsersByEmailAndPassword(String email,String password);
}

