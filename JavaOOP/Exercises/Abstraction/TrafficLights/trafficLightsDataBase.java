package JavaOOP.Exercises.Abstraction.TrafficLights;

public enum trafficLightsDataBase {
    RED("GREEN"),
    GREEN("YELLOW"),
    YELLOW("RED");

    private String name;
    trafficLightsDataBase(String name){
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
