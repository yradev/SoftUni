package softuni.exam.instagraphlite.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import softuni.exam.instagraphlite.models.User.User;

import java.util.List;

//ToDo
@Repository
public interface UserRepository extends JpaRepository<User,Integer> {
    User findUserByUserName(String userName);

    @Query("SELECT a FROM User a " +
            "ORDER BY a.posts.size DESC, a.id ASC")
    List<User>findUsersWithPosts();
}
