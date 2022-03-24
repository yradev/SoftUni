package car_dealer.repositories;

import car_dealer.entities.suppliers.Supplier;
import car_dealer.entities.suppliers.SupplierWithoutImportedPartsFromAbroad;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SupplierRepository extends JpaRepository<Supplier,Integer> {
    @Query("SELECT new car_dealer.entities.suppliers.SupplierWithoutImportedPartsFromAbroad(a.id,a.name,a.parts.size) " +
            "FROM Supplier a " +
            "WHERE a.isImporter = false")
    List<SupplierWithoutImportedPartsFromAbroad>findSuppliersWithoutImportedPartsFromAbroad();
}
