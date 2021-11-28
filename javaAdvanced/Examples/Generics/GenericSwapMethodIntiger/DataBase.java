package Generics.GenericSwapMethodIntiger;

import java.util.ArrayList;
import java.util.List;

public class DataBase <T>{
    private List<T> Data;

    public DataBase(){
        this.Data = new ArrayList<>();
    }

    public void add(T Element){
        this.Data.add(Element);
    }

    public void swap(int Index1, int Index2){
        T value = this.Data.get(Index1);
        this.Data.set(Index1,this.Data.get(Index2));
        this.Data.set(Index2,value);
    }

    @Override
    public String toString(){
        StringBuilder Print = new StringBuilder();
        this.Data.forEach(a->Print.append(String.format("%s: %s\n",this.Data.get(0).getClass().getName(),a)));
        return Print.toString();
    }
}
