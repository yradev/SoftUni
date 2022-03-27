package car_dealer.entities.cars;

import javax.xml.bind.annotation.*;

@XmlAccessorType(XmlAccessType.FIELD)
public class CarFromToyotaDTO {
    @XmlAttribute
    private int id;
    @XmlAttribute
    private String make;
    @XmlAttribute
    private String model;
    @XmlAttribute(name = "travelled-distance")
    private long travelledDistance;

    public CarFromToyotaDTO() {
    }

    public CarFromToyotaDTO(int id, String make, String model, long travelledDistance) {
        this.id = id;
        this.make = make;
        this.model = model;
        this.travelledDistance = travelledDistance;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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
}