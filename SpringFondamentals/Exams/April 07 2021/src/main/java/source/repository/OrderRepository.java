package source.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import source.model.entity.Order;

import java.util.List;

public interface OrderRepository extends JpaRepository<Order,Long> {
}
