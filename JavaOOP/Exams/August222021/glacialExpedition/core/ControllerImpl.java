package Exams.August222021.glacialExpedition.core;

import Exams.August222021.glacialExpedition.models.explorers.*;
import Exams.August222021.glacialExpedition.models.mission.Mission;
import Exams.August222021.glacialExpedition.models.mission.MissionImpl;
import Exams.August222021.glacialExpedition.models.states.State;
import Exams.August222021.glacialExpedition.models.states.StateImpl;
import Exams.August222021.glacialExpedition.repositories.ExplorerRepository;
import Exams.August222021.glacialExpedition.repositories.StateRepository;

import java.util.List;
import java.util.stream.Collectors;

import static Exams.August222021.glacialExpedition.common.ConstantMessages.*;
import static Exams.August222021.glacialExpedition.common.ExceptionMessages.*;

public class ControllerImpl implements Controller {
   private ExplorerRepository explorerRepository;
   private StateRepository stateRepository;
   private int exploreStats;

    public ControllerImpl() {
        this.explorerRepository = new ExplorerRepository();
        this.stateRepository = new StateRepository();
    }

    @Override
    public String addExplorer(String type, String explorerName) {
        Explorer explorer = getExplorer(explorerName,type);

        if(explorer == null){
            throw new IllegalArgumentException(EXPLORER_INVALID_TYPE);
        }

        explorerRepository.add(explorer);
        return String.format(EXPLORER_ADDED,type,explorerName);
    }

    private Explorer getExplorer(String explorerName, String type) {
        switch (type){
            case"AnimalExplorer": return new AnimalExplorer(explorerName);
            case"GlacierExplorer": return new GlacierExplorer(explorerName);
            case"NaturalExplorer": return new NaturalExplorer(explorerName);
        }
        return null;
    }

    @Override
    public String addState(String stateName, String... exhibits) {
        State state = new StateImpl(stateName);
        for (String exhibit : exhibits) {
            state.getExhibits().add(exhibit);
        }
        this.stateRepository.add(state);
        return String.format(STATE_ADDED,stateName);
    }

    @Override
    public String retireExplorer(String explorerName) {
        Explorer explorer =  explorerRepository.byName(explorerName);
        if(explorer == null){
            throw new IllegalArgumentException(String.format(EXPLORER_DOES_NOT_EXIST,explorerName));
        }
        explorerRepository.getCollection().remove(explorer);
        return String.format(EXPLORER_RETIRED,explorerName);
    }

    @Override
    public String exploreState(String stateName) {
        List<Explorer> tempExplorers = explorerRepository
                .getCollection()
                .stream()
                .filter(a->a.getEnergy()>50)
                .collect(Collectors.toList());

        if(tempExplorers.isEmpty()){
         throw new IllegalArgumentException(STATE_EXPLORERS_DOES_NOT_EXISTS);
        }

        State stateToExplore = stateRepository.byName(stateName);

        Mission mission = new MissionImpl();

        mission.explore(stateToExplore, tempExplorers);
        exploreStats++;

        long retired = tempExplorers.stream().filter(e -> e.getEnergy() == 0 ).count();

        return String.format(STATE_EXPLORER, stateName, retired);
    }

    @Override
    public String finalResult() {
        StringBuilder printer = new StringBuilder();
        printer.append(String.format(FINAL_STATE_EXPLORED,exploreStats)).append(System.lineSeparator());
        printer.append(FINAL_EXPLORER_INFO);

        for (Explorer explorer : explorerRepository.getCollection()) {
            printer.append(System.lineSeparator());
            printer.append(String.format(FINAL_EXPLORER_NAME,explorer.getName())).append(System.lineSeparator());
            printer.append(String.format(FINAL_EXPLORER_ENERGY,explorer.getEnergy())).append(System.lineSeparator());

            String exhibits = explorer.getSuitcase().getExhibits().isEmpty()
                    ? "None"
                    : String.join(FINAL_EXPLORER_SUITCASE_EXHIBITS_DELIMITER, explorer.getSuitcase().getExhibits());
            printer.append(String.format(FINAL_EXPLORER_SUITCASE_EXHIBITS, exhibits));
        }
        return printer.toString();
    }
}
