package softuni.exam.models.dto.offer.importDTO;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

@XmlAccessorType(XmlAccessType.FIELD)
public class OfferImportDTO {
    @XmlElement
    @NotNull
    @Positive
    private BigDecimal price;

    @NotNull
    @XmlElement
    private AgentNameDTO agent;

    @NotNull
    @XmlElement
    private ApartmentIdDTO apartment;

    @XmlElement
    @NotNull
    private String publishedOn;

    public OfferImportDTO (){}

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public AgentNameDTO getAgent() {
        return agent;
    }

    public void setAgent(AgentNameDTO agent) {
        this.agent = agent;
    }

    public ApartmentIdDTO getApartment() {
        return apartment;
    }

    public void setApartment(ApartmentIdDTO apartment) {
        this.apartment = apartment;
    }

    public LocalDate getPublishedOn() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        return LocalDate.parse(publishedOn,formatter);
    }

    public void setPublishedOn(String publishedOn) {
        this.publishedOn = publishedOn;
    }
}
