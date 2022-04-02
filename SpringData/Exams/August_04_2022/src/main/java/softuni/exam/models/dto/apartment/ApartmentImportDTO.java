package softuni.exam.models.dto.apartment;

import softuni.exam.models.entity.ApartmentTypes;

import javax.validation.constraints.NotNull;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.Min;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;

@XmlAccessorType(XmlAccessType.FIELD)
public class ApartmentImportDTO {

    @XmlElement
    @Enumerated(value = EnumType.STRING)
    @NotNull
    private ApartmentTypes apartmentType;

    @XmlElement
    @Min(40)
    private double area;

    @XmlElement(name = "town")
    private String townTownName;

    public ApartmentImportDTO(){}

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

    public String getTownTownName() {
        return townTownName;
    }

    public void setTownTownName(String townTownName) {
        this.townTownName = townTownName;
    }
}
