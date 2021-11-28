package Generics.GenericCountMethodStrings;

import java.util.ArrayList;
import java.util.List;
public class DataBase <T extends Comparable<T>>{
    private List<T> Data;

    public DataBase(){
        this.Data = new ArrayList<>();
    }

    public void add(T Element){
        this.Data.add(Element);
    }

    public int countOfGreaterItems(T element){
        return (int)Data.stream().filter(a -> a.compareTo(element) > 0).count();
    }
}
