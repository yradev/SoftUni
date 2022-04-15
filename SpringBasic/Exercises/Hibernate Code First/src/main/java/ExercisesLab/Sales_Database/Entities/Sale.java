package ExercisesLab.Sales_Database.Entities;

import javax.persistence.*;

@Entity
@Table (name = "sale")
public class Sale {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @ManyToOne(optional = false)
    @JoinColumn(name = "product_id",referencedColumnName = "id")
    private Product product;

    @ManyToOne(optional = false)
    @JoinColumn(name = "cusomer_id",referencedColumnName = "id")
    private Customer customer;

    @ManyToOne(optional = false)
    @JoinColumn(name = "store_location_id",referencedColumnName = "id")
    private StoreLocation storeLocation;
}
