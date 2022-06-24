package source.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import source.model.dto.UserRegisterDTO;
import source.model.entity.User;

@Repository
public interface UserRepository extends JpaRepository<User,Long> {
    User findUserByEmail(String email);
    User findUserByUsername(String username);
    User findUserByUsernameAndPassword(String username,String password);
}
