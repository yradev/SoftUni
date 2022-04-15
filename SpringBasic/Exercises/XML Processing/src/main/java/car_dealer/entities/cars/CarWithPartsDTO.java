package car_dealer.entities.cars;

import car_dealer.entities.parts.PartInfoDTO;

import javax.xml.bind.annotation.*;
import java.util.Set;

@XmlAccessorType(XmlAccessType.FIELD)
public class CarWithPartsDTO {
    @XmlAttribute
    private String make;
    @XmlAttribute
    private String model;
    @XmlAttribute(name = "travelled-distance")
    private long travelledDistance;

    @XmlElementWrapper(name = "parts")
    @XmlElement(name = "part")
    private Set<PartInfoDTO> parts;

    public CarWithPartsDTO() {
    }

    public CarWithPartsDTO(String make, String model, long travelledDistance, Set<PartInfoDTO> parts) {
        this.make = make;
        this.model = model;
        this.travelledDistance = travelledDistance;
        this.parts = parts;
    }

    public String getMake() {
        return make;
    }

    public void setMake(String make) {
        this.make = make;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public long getTravelledDistance() {
        return travelledDistance;
    }

    public void setTravelledDistance(long travelledDistance) {
        this.travelledDistance = travelledDistance;
    }

    public Set<PartInfoDTO> getParts() {
        return parts;
    }

    public void setParts(Set<PartInfoDTO> parts) {
        this.parts = parts;
    }
}
