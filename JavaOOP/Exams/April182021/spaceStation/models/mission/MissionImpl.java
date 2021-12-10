package Exams.April182021.spaceStation.models.mission;

import Exams.April182021.spaceStation.models.astronauts.Astronaut;
import Exams.April182021.spaceStation.models.planets.Planet;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class MissionImpl implements Mission{
    @Override
    public void explore(Planet planet, Collection<Astronaut> astronauts) {
        List<String>bag = new ArrayList<>(planet.getItems());
        for (Astronaut astronaut : astronauts) {
            while(astronaut.canBreath() && !bag.isEmpty()){
                astronaut.getBag().getItems().add(bag.get(0));
                bag.remove(0);
                astronaut.breath();
                if(astronaut.getOxygen()==0){
                    break;
                }
            }
        }

    }
}
