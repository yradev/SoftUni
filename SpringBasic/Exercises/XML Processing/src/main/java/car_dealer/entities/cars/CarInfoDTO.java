package car_dealer.entities.cars;

import car_dealer.entities.parts.Part;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import java.util.Set;


@XmlAccessorType(XmlAccessType.NONE)
public class CarInfoDTO {
    @XmlAttribute
    private String Make;
    @XmlAttribute
    private String Model;
    @XmlAttribute
    private long TravelledDistance;

    private Set<Part> parts;

    public CarInfoDTO() {
    }

    public String getMake() {
        return Make;
    }

    public void setMake(String make) {
        Make = make;
    }

    public String getModel() {
        return Model;
    }

    public void setModel(String model) {
        Model = model;
    }

    public long getTravelledDistance() {
        return TravelledDistance;
    }

    public void setTravelledDistance(long travelledDistance) {
        TravelledDistance = travelledDistance;
    }

    public Set<Part> getParts() {
        return parts;
    }

    public void setParts(Set<Part> parts) {
        this.parts = parts;
    }
}