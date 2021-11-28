package Exams.June262021.groomingSalon;

import java.util.ArrayList;
import java.util.List;

public class GroomingSalon {
    private int capacity;
    private List<Pet> data;

    public GroomingSalon(int capacity){
        this.capacity = capacity;
        data = new ArrayList<>();
    }

    public void add(Pet pet){
        if(this.capacity>this.data.size()){
            data.add(pet);
        }
    }

    public boolean remove(String name){
        boolean isTrue=false;

        for(int i=0;i<data.size();i++){
            if(data.get(i).getName().equals(name)){
                data.remove(i);
                isTrue=true;
                break;
            }
        }
        return isTrue;
    }

    public Pet getPet(String name, String owner){
        Pet Saved = null;
        for (Pet datum : data) {
            if (datum.getName().equals(name) && datum.getOwner().equals(owner)) {
                Saved = datum;
            }
        }
        return Saved;
    }

    public int getCount(){
        return data.size();
    }

    public String getStatistics(){
        StringBuilder SomeReturn = new StringBuilder();
        SomeReturn.append(String.format("The grooming salon has the following clients:")).append(System.lineSeparator());
        for (Pet datum : data) {
            SomeReturn.append(String.format("%s %s",datum.getName(),datum.getOwner()));
            SomeReturn.append(System.lineSeparator());
        }

        return SomeReturn.toString();
    }

}
