package source.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import source.model.entity.Category;

public interface CategoryRepository extends JpaRepository<Category,Long> {
    Category findByName(String name);
}
