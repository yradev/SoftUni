package JavaAdvanced.Exams.February202021.dealership;

import java.util.ArrayList;
import java.util.List;

public class Dealership {
    public String name;
    public int capacity;
    List<Car> data;

    public Dealership(String name, int capacity) {
        this.name = name;
        this.capacity = capacity;
        data = new ArrayList<>();
    }

    public void add(Car car){
        if(data.size()<capacity){
            data.add(car);
        }
    }

    public boolean buy(String manufacturer, String model){
        for (Car datum : data) {
            if(datum.manufacturer.equals(manufacturer) && datum.model.equals(model)){
                data.remove(datum);
                return true;
            }
        }
        return false;
    }

    public Car getLatestCar(){
        Car car = null;
        if(!data.isEmpty()){
            car = data.stream().sorted((a,b)->Integer.compare(b.getYear(),a.getYear())).findFirst().get();
        }
        return car;
    }

    public Car getCar(String manufacturer, String model){
        for (Car datum : data) {
            if(datum.manufacturer.equals(manufacturer) && datum.model.equals(model)){
                return datum;
            }
        }

        return null;
    }

    public int getCount(){
        return data.size();
    }

    public String getStatistics(){
        StringBuilder toPrint = new StringBuilder();
        toPrint.append(String.format("The cars are in a car dealership %s:",name)).append(System.lineSeparator());
        for (Car datum : data) {
            toPrint.append(datum);
            toPrint.append(System.lineSeparator());
        }

        return toPrint.toString();
    }
}
