package source.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import source.model.entity.User;

public interface UserRepository extends JpaRepository<User,Long> {
    User findUserByUsername(String username);
    User findUserByEmail(String email);
    User findUserByUsernameAndPassword(String username, String password);
}
