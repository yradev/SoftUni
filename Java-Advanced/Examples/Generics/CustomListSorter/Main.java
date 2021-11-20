package Generics.CustomListSorter;

import java.util.*;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        DataBase<String>dataBase = new DataBase<>();
        while(true){
            List<String> Input = Arrays.stream(scanner.nextLine().split(" ")).collect(Collectors.toList());
            if(Input.get(0).equals("END")){
                break;
            }

            String Command = Input.get(0);
            String Element;
            switch (Command){
                case"Add":
                    Element = Input.get(1);
                    dataBase.add(Element);
                    break;
                case"Remove":
                    int Index = Integer.parseInt(Input.get(1));
                    dataBase.remove(Index);
                    break;
                case"Contains":
                    Element = Input.get(1);
                    System.out.println(dataBase.contains(Element));
                    break;
                case"Swap":
                    int Index1 = Integer.parseInt(Input.get(1));
                    int Index2 = Integer.parseInt(Input.get(2));
                    dataBase.swap(Index1,Index2);
                    break;
                case"Greater":
                    Element = Input.get(1);
                    System.out.println(dataBase.countGreaterThan(Element));
                    break;
                case"Max":
                    System.out.println(dataBase.Max());
                    break;
                case"Min":
                    System.out.println(dataBase.Min());
                    break;
                case"Print":
                    dataBase.Print();
                    break;
                case"Sort":
                    Sorter.sort(dataBase);
                    break;
            }
        }
    }
}
