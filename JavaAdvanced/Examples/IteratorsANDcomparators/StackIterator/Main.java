package JavaAdvanced.Examples.IteratorsANDcomparators.StackIterator;

import java.util.*;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Stacks stack = new Stacks();
        while(true){
            List<String>Input = Arrays.stream(scanner.nextLine().split(" ")).collect(Collectors.toList());
            String Command = Input.get(0);
            if(Command.equals("END")){
                stack.End();
                break;
            }
            List<String> SubList  = Input.subList(1,Input.size());
            String SubJoin = String.join("",SubList);
            String Sub = String.join(" ", SubJoin.split(","));

            switch(Command){
                case"Push":
                    stack.Push(Sub.split(" "));
                    break;
                case"Pop":
                    stack.Pop();
                    break;
            }
        }
    }
}
