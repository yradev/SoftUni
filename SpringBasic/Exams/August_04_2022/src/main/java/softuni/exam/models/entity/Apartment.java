package softuni.exam.models.entity;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "apartments")
public class Apartment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "apartment_type",nullable = false)
    @Enumerated(value = EnumType.STRING)
    private ApartmentTypes apartmentType;

    @Column(nullable = false)
    private double area;

    @ManyToOne(optional = false)
    @JoinColumn(name = "town_id",referencedColumnName = "id")
    private Town town;

    @OneToMany(targetEntity = Offer.class,mappedBy = "apartment")
    private Set<Offer> offers;

    public Apartment(){}

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public ApartmentTypes getApartmentType() {
        return apartmentType;
    }

    public void setApartmentType(ApartmentTypes apartmentType) {
        this.apartmentType = apartmentType;
    }

    public double getArea() {
        return area;
    }

    public void setArea(double area) {
        this.area = area;
    }

    public Town getTown() {
        return town;
    }

    public void setTown(Town town) {
        this.town = town;
    }

    public Set<Offer> getOffers() {
        return offers;
    }

    public void setOffers(Set<Offer> offers) {
        this.offers = offers;
    }
}
