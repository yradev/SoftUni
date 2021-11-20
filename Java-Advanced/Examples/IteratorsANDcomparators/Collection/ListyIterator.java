package IteratorsANDcomparators.Collection;

import java.util.*;
import java.util.stream.Collectors;

public class ListyIterator {

        private List<String> DataBase;
        private int CurrentIndex = 0;

        public ListyIterator(){
            DataBase = new ArrayList<>();
        }

        public void Create(String...values){
            DataBase.addAll(Arrays.asList(values));
        }

        public boolean hasNext(){
            return CurrentIndex < DataBase.size()-1;
        }

        public boolean MoveNext(){
            if(hasNext()){
                CurrentIndex++;
                return true;
            }else {
                return false;
            }
        }

        public void Print(){
            if(DataBase.size()==0){
                throw new IllegalStateException("Invalid Operation!");
            }else{
                System.out.println(DataBase.get(CurrentIndex));
            }
        }

        public void PrintAll(){
            if(DataBase.size()==0){
                throw new IllegalStateException("Invalid Operation!");
            }else{
                System.out.println(String.join(" ", DataBase));
            }
        }
    }