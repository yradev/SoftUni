package Exams.April182021.spaceStation.core;

import Exams.April182021.spaceStation.models.astronauts.Astronaut;
import Exams.April182021.spaceStation.models.astronauts.Biologist;
import Exams.April182021.spaceStation.models.astronauts.Geodesist;
import Exams.April182021.spaceStation.models.astronauts.Meteorologist;
import Exams.April182021.spaceStation.models.mission.Mission;
import Exams.April182021.spaceStation.models.mission.MissionImpl;
import Exams.April182021.spaceStation.models.planets.Planet;
import Exams.April182021.spaceStation.models.planets.PlanetImpl;
import Exams.April182021.spaceStation.repositories.AstronautRepository;
import Exams.April182021.spaceStation.repositories.PlanetRepository;

import java.util.List;
import java.util.stream.Collectors;

import static Exams.April182021.spaceStation.common.ConstantMessages.*;
import static Exams.April182021.spaceStation.common.ExceptionMessages.*;

public class ControllerImpl implements Controller {
    private AstronautRepository astronautRepository;
    private PlanetRepository planetRepository;
    private int countExploredPlanets;

    public ControllerImpl() {
        this.astronautRepository = new AstronautRepository();
        this.planetRepository = new PlanetRepository();
        countExploredPlanets = 0;
    }

    @Override
    public String addAstronaut(String type, String astronautName) {
        Astronaut astronaut = null;
        switch (type){
            case"Biologist": astronaut = new Biologist(astronautName);break;
            case"Geodesist": astronaut = new Geodesist(astronautName);break;
            case"Meteorologist": astronaut = new Meteorologist(astronautName);break;

        }

        if(astronaut==null){
            throw new IllegalArgumentException(ASTRONAUT_INVALID_TYPE);
        }

        astronautRepository.add(astronaut);
        return String.format(ASTRONAUT_ADDED,type,astronautName);
    }

    @Override
    public String addPlanet(String planetName, String... items) {
        Planet planet = new PlanetImpl(planetName);
        for (String item : items) {
            planet.getItems().add(item);
        }
        planetRepository.add(planet);
        return String.format(PLANET_ADDED,planetName);
    }

    @Override
    public String retireAstronaut(String astronautName) {
       Astronaut astronaut =  astronautRepository.findByName(astronautName);
       if(astronaut==null){
           throw new IllegalArgumentException(String.format(ASTRONAUT_DOES_NOT_EXIST,astronautName));
       }

       astronautRepository.remove(astronaut);
        return String.format(ASTRONAUT_RETIRED,astronautName);
    }

    @Override
    public String explorePlanet(String planetName) {
        Planet planet = planetRepository.findByName(planetName);
        Mission mission = new MissionImpl();
        List<Astronaut> astronauts = astronautRepository.getModels().stream().filter(a -> a.getOxygen() > 60).collect(Collectors.toList());
        if(astronauts.isEmpty()){
            throw new IllegalArgumentException(PLANET_ASTRONAUTS_DOES_NOT_EXISTS);
        }
        mission.explore(planet,astronauts);
        astronauts = astronauts.stream().filter(a->a.getOxygen()==0).collect(Collectors.toList());
        int countOfDiedAustronauts = astronauts.size();
        countExploredPlanets++;
        return String.format(PLANET_EXPLORED,planetName,countOfDiedAustronauts);
    }

    @Override
    public String report() {
        StringBuilder print = new StringBuilder();
        print.append(String.format(REPORT_PLANET_EXPLORED,countExploredPlanets)).append(System.lineSeparator());
        print.append(REPORT_ASTRONAUT_INFO).append(System.lineSeparator());
        for (Astronaut model : astronautRepository.getModels()) {
            print.append(String.format(REPORT_ASTRONAUT_NAME,model.getName())).append(System.lineSeparator());
            print.append(String.format(REPORT_ASTRONAUT_OXYGEN,model.getOxygen())).append(System.lineSeparator());
            String bag = model.getBag().getItems().isEmpty()
                    ? "none"
                    : String.join(REPORT_ASTRONAUT_BAG_ITEMS_DELIMITER, model.getBag().getItems());

            print.append(String.format(REPORT_ASTRONAUT_BAG_ITEMS,bag)).append(System.lineSeparator());
        }

        return print.toString().trim();
    }
}
