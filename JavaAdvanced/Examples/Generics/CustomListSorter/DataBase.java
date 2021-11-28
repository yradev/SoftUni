package JavaAdvanced.Examples.Generics.CustomListSorter;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class DataBase <T extends Comparable <T>>{
    private List<T> Data;

    public DataBase(){
        this.Data = new ArrayList<>();
    }
    public void add(T element){
        this.Data.add(element);
    }

    public T remove(int Index){
        return this.Data.remove(Index);
    }

    public boolean contains(T element){
        return this.Data.contains(element);
    }

    public void swap(int index1, int index2){
        Collections.swap(this.Data,index1,index2);
    }

    public int countGreaterThan(T element){
        return (int)Data.stream().filter(a -> a.compareTo(element) > 0).count();
    }

    public T Max (){
        return this.Data.stream().max(Comparable::compareTo).get();
    }

    public T Min (){
        return this.Data.stream().min(Comparable::compareTo).get();
    }

    public void Print(){
        this.Data.forEach(System.out::println);
    }

    public int size(){
        return Data.size();
    }
    public T get(int index){
        return Data.get(index);
    }


}
