package ExercisesLab.Sales_Database.Entities;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Set;

@Entity
@Table (name = "product")
public class Product {
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private int id;

    private String name;
    private Double quantity;
    private BigDecimal price;

    @OneToMany(targetEntity = Sale.class,mappedBy = "product")
    private Set<Sale>sales;
}
