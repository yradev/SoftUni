package JavaAdvanced.Examples.DefiningClasses.CarSalesman;

public class Engine {
    private String Model;
    private int Power;
    private String Displacement;
    private String Efficiency;

    public String getModel() {
        return Model;
    }

    public Engine(String Model, int Power, String Displacement, String Efficiency){
        this.Model = Model;
        this.Power=Power;
        this.Displacement=Displacement;
        this.Efficiency=Efficiency;

    }
    @Override
    public String toString(){
        return String.format("Power: %s\nDisplacement: %s\nEfficiency: %s\n",Power,Displacement,Efficiency);
    }
}
