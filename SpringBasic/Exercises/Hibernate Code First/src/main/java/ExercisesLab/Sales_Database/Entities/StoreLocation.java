package ExercisesLab.Sales_Database.Entities;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Set;

@Entity
@Table (name = "store_location")
public class StoreLocation {
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private int id;

    @OneToMany(targetEntity = Sale.class,mappedBy = "storeLocation")
    private Set<Sale> sales;
    private LocalDate date;

    public StoreLocation() {
    }
}
