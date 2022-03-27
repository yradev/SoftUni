package products_shop.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import products_shop.Entities.Categories.CategorieByProductsCountDTO;
import products_shop.Entities.Categories.Category;

import java.util.List;

@Repository
public interface CategoryRepository extends JpaRepository<Category,Integer> {

    @Query("SELECT new products_shop.Entities.Categories.CategorieByProductsCountDTO(c.name,c.products.size,AVG(p.price),SUM(p.price))" +
            " FROM categories c " +
            " JOIN c.products p ")
    List<CategorieByProductsCountDTO> findByProductsCount();
}
