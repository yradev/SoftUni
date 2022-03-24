package car_dealer.entities.cars;

import car_dealer.entities.parts.PartInfoDTO;

import java.util.Set;

public class CarWithPartsDTO {
    private String Make;
    private String Model;
    private long TravelledDistance;

    private Set<PartInfoDTO> parts;

    public CarWithPartsDTO(String make, String model, long travelledDistance, Set<PartInfoDTO> parts) {
        Make = make;
        Model = model;
        TravelledDistance = travelledDistance;
        this.parts = parts;
    }

    public CarWithPartsDTO() {
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

    public Set<PartInfoDTO> getParts() {
        return parts;
    }

    public void setParts(Set<PartInfoDTO> parts) {
        this.parts = parts;
    }
}
