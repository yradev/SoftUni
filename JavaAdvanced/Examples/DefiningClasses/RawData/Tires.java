package JavaAdvanced.Examples.DefiningClasses.RawData;

public class Tires {
   private double Pressure1;
   private int Age1;
    private double Pressure2;
    private int Age2;
    private double Pressure3;
    private int Age3;
    private double Pressure4;
    private int Age4;

    public void setTires(double pressure1, int age1, double pressure2, int age2, double pressure3, int age3, double pressure4, int age4) {
        Pressure1 = pressure1;
        Age1 = age1;
        Pressure2 = pressure2;
        Age2 = age2;
        Pressure3 = pressure3;
        Age3 = age3;
        Pressure4 = pressure4;
        Age4 = age4;
    }

    public double getPressure1() {
        return Pressure1;
    }

    public double getPressure2() {
        return Pressure2;
    }

    public double getPressure3() {
        return Pressure3;
    }

    public double getPressure4() {
        return Pressure4;
    }
}
