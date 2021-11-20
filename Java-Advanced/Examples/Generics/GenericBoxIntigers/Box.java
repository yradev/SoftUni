package Generics.GenericBoxIntigers;

import java.util.ArrayList;
import java.util.List;

public class Box <T> {
    private List<T> DataBase;

    public Box(){
        this.DataBase =new ArrayList<>();
    }

    public void add(T Value){
        this.DataBase.add(Value);
    }

    @Override
    public String toString(){
        StringBuilder Print = new StringBuilder();
        this.DataBase.forEach(a->Print.append(String.format("%s: %s\n",this.DataBase.get(0).getClass().getName(),a)));
        return Print.toString();
    }
}
