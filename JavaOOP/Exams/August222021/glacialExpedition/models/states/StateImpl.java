package Exams.August222021.glacialExpedition.models.states;

import java.util.ArrayList;
import java.util.Collection;

import static Exams.August222021.glacialExpedition.common.ExceptionMessages.STATE_NAME_NULL_OR_EMPTY;

public class StateImpl implements State{
    private String name;
    private Collection <String>exhibits;

    public StateImpl(String name) {
        this.name = name;
        exhibits = new ArrayList();
    }

    public void setName(String name) {
        if(name==null || name.trim().isEmpty()){
            throw new NullPointerException(STATE_NAME_NULL_OR_EMPTY);
        }
        this.name = name;
    }

    @Override
    public Collection<String> getExhibits() {
        return exhibits;
    }

    @Override
    public String getName() {
        return name;
    }
}
