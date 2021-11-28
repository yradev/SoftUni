package JavaFundamentals.Exercises.List;

import java.util.*;
import java.util.stream.Collectors;

public class ListOperations {
    public static void main(String[] args) {
        Scanner Input = new Scanner(System.in);
        List <Integer> Numbers = Arrays.stream(Input.nextLine().split(" ")).map(Integer::parseInt).collect(Collectors.toList());

        String input = Input.nextLine();

        while(!input.equalsIgnoreCase("end")){

            String [] InputString = input.split(" ");
            switch (InputString[0]){
                case"Add":
                    Numbers.add(Integer.parseInt(InputString[1]));
                    break;
                case"Insert":
                    int Number = Integer.parseInt(InputString[1]);
                    int Index = Integer.parseInt(InputString[2]);
                    if(Index>=Numbers.size() || Index<0){
                        System.out.println("Invalid index");
                    }else{
                        Numbers.add(Index, Number);
                    }break;
                case"Remove":
                    Index = Integer.parseInt(InputString[1]);
                    if(Index>=Numbers.size() || Index<0) {
                        System.out.println("Invalid index");
                    }else{
                        Numbers.remove(Index);
                    }
                    break;
                case"Shift":
                    String Command = InputString[1];
                    int Count = Integer.parseInt(InputString[2]);

                    switch(Command) {
                        case "left":
                            for (int i = 0; i < Count; i++) {
                                Numbers.add(Numbers.get(0));
                                Numbers.remove(0);
                            }
                            break;
                        case "right":
                            for(int i=0;i<Count;i++){
                                Numbers.add(0,Numbers.get(Numbers.size()-1));
                                Numbers.remove(Numbers.size()-1);
                            }
                            break;
                    }
                    break;
            }
            input = Input.nextLine();
        }
        String EndString = Numbers.stream().map(String::valueOf) .collect(Collectors.joining(" "));
        System.out.println(EndString);
    }
}
