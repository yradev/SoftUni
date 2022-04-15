package car_dealer.entities.sales;

public enum Discounts {
    P_0(0.0),
    P_5(0.05),
    P_10(0.1),
    P_15(0.15),
    P_20(0.2),
    P_30(0.3),
    P_40(0.4),
    P_50(0.5);

    private final double value;

    Discounts(double value) {
        this.value = value;
    }

    public double getValue(){
        return value;
    }
}
