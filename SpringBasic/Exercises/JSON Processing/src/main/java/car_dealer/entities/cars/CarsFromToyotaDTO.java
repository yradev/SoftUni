package car_dealer.entities.cars;

public class CarsFromToyotaDTO {
    private int Id;
    private String Make;
    private String Model;
    private long TravelledDistance;

    public CarsFromToyotaDTO(int id, String make, String model, long travelledDistance) {
        Id = id;
        Make = make;
        Model = model;
        TravelledDistance = travelledDistance;
    }

    public int getId() {
        return Id;
    }

    public void setId(int id) {
        Id = id;
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
}
