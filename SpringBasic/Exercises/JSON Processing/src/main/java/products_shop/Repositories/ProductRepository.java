package products_shop.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import products_shop.Entities.Categories.CategorieByProductsCountDTO;
import products_shop.Entities.Products.Product;
import products_shop.Entities.Products.ProductsInRangeDTO;

import java.math.BigDecimal;
import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<Product,Integer>{

    @Query("SELECT new products_shop.Entities.Products.ProductsInRangeDTO(a.name,a.price,a.seller.firstName,a.seller.lastName) FROM products a WHERE a.price BETWEEN :start AND :end and a.buyer IS NULL ORDER BY a.price ASC" )
    List<ProductsInRangeDTO>findProductsBySpecificPrice(BigDecimal start, BigDecimal end);

    @Query("SELECT new products_shop.Entities.Categories.CategorieByProductsCountDTO(c.name)" +
            " FROM products p " +
            " JOIN p.categories c " +
            " GROUP BY c")
    List<CategorieByProductsCountDTO> findByProductsCount();



}
