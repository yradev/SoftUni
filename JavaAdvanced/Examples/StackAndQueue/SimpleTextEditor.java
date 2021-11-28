package JavaAdvanced.Examples.StackAndQueue;

import jdk.jshell.Snippet;

import java.awt.*;
import java.util.*;
import java.util.List;
import java.util.stream.Collectors;

public class SimpleTextEditor {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int Moves = Integer.parseInt(input.nextLine());
        ArrayDeque<String>LastMove = new ArrayDeque<>();
        StringBuilder text = new StringBuilder();
        for(int i=1;i<=Moves;i++){
            List<String>Split = Arrays.stream(input.nextLine().split(" ")).collect(Collectors.toList());
            String Command = Split.get(0);
            switch (Command){
                case"1":
                    LastMove.push(text.toString());
                    String valueToAppend = Split.get(1);
                    text.append(valueToAppend);
                    break;
                case"2":
                    LastMove.push(text.toString());
                    int CountToErase = Integer.parseInt(Split.get(1));
                    text.delete(text.length()-CountToErase,text.length());
                    break;
                case"3":
                    int PositionToPrint = Integer.parseInt(Split.get(1));
                    System.out.println(text.charAt(PositionToPrint-1));
                    break;
                case"4":
                    text.replace(0,text.length(),LastMove.pop());
                    break;
            }
        }
    }
}
