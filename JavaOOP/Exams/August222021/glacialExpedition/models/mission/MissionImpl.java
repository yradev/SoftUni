package Exams.August222021.glacialExpedition.models.mission;

import Exams.August222021.glacialExpedition.models.explorers.Explorer;
import Exams.August222021.glacialExpedition.models.states.State;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class MissionImpl implements Mission{
    @Override
    public void explore(State state, Collection<Explorer> explorers) {
        List<String> states = new ArrayList<>(state.getExhibits());
        for (Explorer explorer : explorers) {
            while(explorer.canSearch() && !states.isEmpty()){
                String currentExhibit = states.get(0);
                explorer.getSuitcase().getExhibits().add(currentExhibit);
                states.remove(currentExhibit);
                explorer.search();
            }
        }
    }
}
