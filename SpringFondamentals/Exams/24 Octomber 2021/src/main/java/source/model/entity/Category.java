package source.model.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.Set;

@Entity
@Table(name = "categories")
public class Category extends BaseEntity {
    @Column(unique = true)
    private Categories name;
    @Column(columnDefinition = "text")
    private String description;

    @OneToMany(targetEntity = Ship.class , mappedBy = "category")
    private Set<Ship> ships;

    public Category(){}

    public Categories getName() {
        return name;
    }

    public void setName(Categories name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Set<Ship> getShips() {
        return ships;
    }

    public void setShips(Set<Ship> ships) {
        this.ships = ships;
    }
}
