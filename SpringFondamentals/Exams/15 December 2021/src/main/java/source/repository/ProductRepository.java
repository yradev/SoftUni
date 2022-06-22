package source.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import source.model.entity.Product;

import java.util.List;

public interface ProductRepository extends JpaRepository<Product,Long> {}
