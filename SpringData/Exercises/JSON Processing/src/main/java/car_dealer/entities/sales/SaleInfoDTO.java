package car_dealer.entities.sales;

import car_dealer.entities.cars.Car;

public class SaleInfoDTO {
    private Long saleId;
    private Discounts discount;
    private int carId;
    private String carMake;
    private String carModel;
    private long carTravelledDistance;

    public SaleInfoDTO() {
    }

    public Long getId() {
        return saleId;
    }

    public void setId(Long id) {
        this.saleId = id;
    }

    public Discounts getDiscount() {
        return discount;
    }

    public void setDiscount(Discounts discount) {
        this.discount = discount;
    }


    public int getCarId() {
        return carId;
    }

    public void setCarId(int carId) {
        this.carId = carId;
    }

    public String getCarModel() {
        return carModel;
    }

    public void setCarModel(String carModel) {
        this.carModel = carModel;
    }

    public String getCarMake() {
        return carMake;
    }

    public void setCarMake(String carMake) {
        this.carMake = carMake;
    }

    public long getCarTravelledDistance() {
        return carTravelledDistance;
    }

    public void setCarTravelledDistance(long carTravelledDistance) {
        this.carTravelledDistance = carTravelledDistance;
    }
}
