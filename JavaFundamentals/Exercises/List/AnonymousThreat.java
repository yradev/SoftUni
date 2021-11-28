package JavaFundamentals.Exercises.List;

import java.util.*;
import java.util.stream.Collectors;

public class AnonymousThreat {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        List<String> InputStrings = Arrays.stream(input.nextLine().split(" ")).collect(Collectors.toList());

        String Input = input.nextLine();

        while(!Input.equalsIgnoreCase("3:1")) {
            List<String> Commands = Arrays.stream(Input.split(" ")).collect(Collectors.toList());
            String Command = Commands.get(0);

            switch (Command) {
                case "merge":
                    int StartIndex = Integer.parseInt(Commands.get(1));
                    int LastIndex = Integer.parseInt(Commands.get(2));
                    SetMerge(InputStrings, StartIndex, LastIndex);
                    break;
                case "divide":
                    int Index = Integer.parseInt(Commands.get(1));
                    int Partitions = Integer.parseInt(Commands.get(2));
                    List<String> tempArray = new ArrayList<>();
                    if (Index >= 0 && Index < InputStrings.size() && Partitions >= 0 && Partitions <= 100) {
                        String Word = InputStrings.get(Index);
                        if (Word.length() % Partitions == 0) {
                            int Count = 0;
                            String newValue = "";
                            int PartitionLength = Word.length() / Partitions;
                            for (int i = 0; i <= Word.length() - 1; i++) {
                                newValue += Word.charAt(i);
                                Count++;

                                if (Count == PartitionLength) {
                                    tempArray.add(newValue);
                                    Count = 0;
                                    newValue = "";
                                }
                            }
                        }else {
                            int portionLength = Word.length() / Partitions;
                            int count = 0;
                            for (int i = 0; i < Partitions; i++) {
                                String concat = "";

                                if (i == Partitions - 1) {
                                    for (int j = count; j < Word.length(); j++) {
                                        char symbol = Word.charAt(count);
                                        concat += symbol;
                                        count++;
                                    }
                                } else {
                                    for (int j = 0; j < portionLength; j++) {
                                        char symbol = Word.charAt(count);
                                        concat += symbol;
                                        count++;
                                    }
                                }
                                tempArray.add(concat);
                            }
                        }

                        InputStrings.remove(Index);
                        InputStrings.addAll(Index,tempArray);
                    }

            }
            Input = input.nextLine();
        }

        String endString = InputStrings.stream()
                .collect(Collectors.joining(" "));

        System.out.println(endString);
    }

    private static void SetMerge(List<String> inputStrings, int startIndex, int lastIndex) {
        if(startIndex <0){
            startIndex =0;
        }

        if(lastIndex > inputStrings.size()-1){
            lastIndex = inputStrings.size()-1;
        }

        for(int i = startIndex +1; i<= lastIndex; i++){
            String NewValue = String.join("", inputStrings.get(startIndex), inputStrings.get(startIndex +1));
            inputStrings.set(startIndex,NewValue);
            inputStrings.remove(startIndex +1);
        }
    }
}
