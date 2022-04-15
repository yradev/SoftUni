package softuni.exam.models.dto.offer.exportDTO;

import java.math.BigDecimal;

public class OfferBestDTO {
    private String agentFirstName;
    private String agentLastName;
    private long id;
    private double apartmentArea;
    private String apartmentTownTownName;
    private BigDecimal price;

    public OfferBestDTO(){}

    public String getAgentFirstName() {
        return agentFirstName;
    }

    public void setAgentFirstName(String agentFirstName) {
        this.agentFirstName = agentFirstName;
    }

    public String getAgentLastName() {
        return agentLastName;
    }

    public void setAgentLastName(String agentLastName) {
        this.agentLastName = agentLastName;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public double getApartmentArea() {
        return apartmentArea;
    }

    public void setApartmentArea(double apartmentArea) {
        this.apartmentArea = apartmentArea;
    }

    public String getApartmentTownTownName() {
        return apartmentTownTownName;
    }

    public void setApartmentTownTownName(String apartmentTownTownName) {
        this.apartmentTownTownName = apartmentTownTownName;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return String.format("""
                Agent %s %s with offer №%s
                \t-Apartment area: %.2f
                \t--Town: %s
                \t---Price: %.2f$
                """,agentFirstName,agentLastName,id,apartmentArea,apartmentTownTownName,price);
    }
}
