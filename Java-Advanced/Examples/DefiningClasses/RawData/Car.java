package DefiningClasses.RawData;

import java.util.ArrayList;
import java.util.List;

public class Car {
    private String Model;
    private int EngineSpeed;
    private int EngineModel;
    private Tires tires = new Tires();
    public Car(String model, int engineSpeed, int engineModel, int CargoWeight, String CargoType, double Pressure1, int Age1, double Pressure2, int Age2, double Pressure3, int Age3,double Pressure4,int Age4) {
        Model = model;
        EngineSpeed = engineSpeed;
        EngineModel = engineModel;
        Cargo cargo = new Cargo(CargoWeight,CargoType);
        tires.setTires(Pressure1,Age1,Pressure2,Age2,Pressure3,Age3,Pressure4,Age4);
    }

    public Car(String model, int engineSpeed, int engineModel) {
        Model = model;
        EngineSpeed = engineSpeed;
        EngineModel = engineModel;
    }

    public int getEngineSpeed() {
        return EngineSpeed;
    }

    public boolean isItTrue(){
        boolean isTrue = false;
        if(tires.getPressure1()<1 || tires.getPressure2()<1 || tires.getPressure3()<1 || tires.getPressure4()<1){
            isTrue=true;
        }
        return isTrue;
    }
    public String getModel() {
        return Model;
    }
}
