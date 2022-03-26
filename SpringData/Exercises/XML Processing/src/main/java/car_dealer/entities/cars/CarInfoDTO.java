package car_dealer.entities.cars;

import car_dealer.entities.parts.Part;
import com.google.gson.annotations.Expose;

import java.util.Set;

public class CarInfoDTO {
    @Expose
    private String Make;
    @Expose
    private String Model;
    @Expose
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