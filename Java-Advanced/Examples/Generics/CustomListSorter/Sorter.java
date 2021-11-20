package Generics.CustomListSorter;

public class Sorter {

    public static <T extends Comparable<T>> void sort(DataBase<T> Data){
        for (int i = 0; i < Data.size(); i++) {
            T element = Data.get(i);
            for (int j = i+1; j < Data.size(); j++) {
                T nextElement = Data.get(j);
                if(element.compareTo(nextElement) > 0){
                    Data.swap(i, j);
                }
            }
        }
    }
}

