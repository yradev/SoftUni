package JavaFundamentals.Exercises.ObjectsAndClasses.VehicleCatalogue;

public class Vehicle {
    private String Type;
    private String Model;
    private String Color;
    private int Horsepower;

    public Vehicle(String Type,String Model,String Color,int Horsepower){
        this.Type=Type;
        this.Model=Model;
        this.Color=Color;
        this.Horsepower=Horsepower;
    }

    public String getModel() {
        return Model;
    }

    public int getHorsepower(){
        return Horsepower;
    }

    public String getType(){
        return Type;
    }
    public String getColor(){
        return Color;
    }
    @Override
    public String toString(){
        return String.format("Type: %s\nModel: %s\nColor: %s\nHorsepower: %s",getType().toUpperCase().charAt(0) + this.getType().substring(1),getModel(),getColor(),getHorsepower());
    }
}
