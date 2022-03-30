package exam.repository;

import exam.model.shop.Shop;
import org.springframework.data.jpa.repository.JpaRepository;

//ToDo:
public interface ShopRepository extends JpaRepository<Shop,Integer>{
    Shop findShopByName(String name);
}
