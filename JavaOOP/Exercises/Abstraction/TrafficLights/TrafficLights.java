package JavaOOP.Exercises.Abstraction.TrafficLights;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class TrafficLights {
    private List<String> trafficLights;

    public TrafficLights(String ... values){
        trafficLights = new ArrayList<>();
        trafficLights.addAll(Arrays.asList(values));
    }

    public void Update(){
        for (int i=0;i<trafficLights.size();i++) {
            String newValue = trafficLightsDataBase.valueOf(trafficLights.get(i)).getName();
            trafficLights.set(i,newValue);
        }
    }

    public void PrintResult(){
        trafficLights.forEach(a-> System.out.printf("%s ",a));
        System.out.println();
    }
}
