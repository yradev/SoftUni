package DefiningClasses.CarSalesman;

public class Car {
    private String Model;
    private String Engine;
    private String Weight;
    private String color;

    public Car(String model, String engine, String weight, String color) {
        Model = model;
        Engine = engine;
        Weight = weight;
        this.color = color;
    }

    public String getModel() {
        return Model;
    }

    public String getEngine() {
        return Engine;
    }

    public String getWeight() {
        return Weight;
    }

    public String getColor() {
        return color;
    }
}
