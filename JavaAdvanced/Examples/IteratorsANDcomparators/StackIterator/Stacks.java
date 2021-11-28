package JavaAdvanced.Examples.IteratorsANDcomparators.StackIterator;

import java.util.*;

public class Stacks {
    private ArrayDeque<Integer>Stack;
    public Stacks(){
        Stack = new ArrayDeque<>();
    }

    public void Push(String ... values){
        for (String value : values) {
            Stack.push(Integer.parseInt(value));
        }
    }

    public void Pop(){
        if(Stack.isEmpty()){
            System.out.println("No elements");
        }else {
            Stack.pop();
        }
    }

    public void End(){
        Stack.forEach(System.out::println);
        Stack.forEach(System.out::println);
    }
}
