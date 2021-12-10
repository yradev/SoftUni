package Exams.August222021.glacialExpedition.repositories;

import Exams.August222021.glacialExpedition.models.states.State;

import java.util.ArrayList;
import java.util.Collection;

public class StateRepository implements Repository<State> {
    Collection<State> states;

    public StateRepository() {
        this.states = new ArrayList<>();
    }

    @Override
    public Collection<State> getCollection() {
        return states;
    }

    @Override
    public void add(State state) {
        states.add(state);
    }

    @Override
    public boolean remove(State state) {
        return states.remove(state);
    }

    @Override
    public State byName(String name) {
        for (State state : states) {
            if(state.getName().equals(name)){
                return state;
            }
        }
        return null;
    }
}
