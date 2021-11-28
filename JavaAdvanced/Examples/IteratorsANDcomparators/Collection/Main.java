package JavaAdvanced.Examples.IteratorsANDcomparators.Collection;

import java.util.*;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ListyIterator listyirator = new ListyIterator();

        while(true){
            List<String>Input = Arrays.stream(scanner.nextLine().split(" ")).collect(Collectors.toList());
            String Command = Input.get(0);
            String SubList = String.join(" ", Input.subList(1, Input.size()));
            if(Command.equals("END")) {
                break;
            }
                switch(Command){
                    case"Create":
                        if(Input.size()>1) {
                            listyirator.Create(SubList.split(" "));
                        }
                        break;
                    case"Move":
                        System.out.println(listyirator.MoveNext());
                        break;
                    case"HasNext":
                        System.out.println(listyirator.hasNext());
                        break;
                    case"Print":
                        try{
                            listyirator.Print();
                        }catch (IllegalStateException e){
                            System.out.println(e.getMessage());
                        }
                        break;
                    case"PrintAll":
                        try{
                            listyirator.PrintAll();
                        }catch (IllegalStateException e){
                            System.out.println(e.getMessage());
                        }
                        break;
            }
        }
    }
}
