package JavaFundamentals.Exercises.MapsLLambdaStreamAPI;

import java.util.*;
import java.util.stream.Collectors;

public class CountCharsINaString {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        List<String>Input = Arrays.stream(input.nextLine().split("")).collect(Collectors.toList());

        Map<String,Integer>Words = new LinkedHashMap<>();

        for (String s : Input) {
            if(!Words.containsKey(s) && !s.equalsIgnoreCase(" ")){
                Words.put(s,1);
            }else if(Words.containsKey(s) && !s.equalsIgnoreCase(" ")){
                Words.put(s,Words.get(s)+1);
            }
        }

        for (Map.Entry<String, Integer> stringIntegerEntry : Words.entrySet()) {
            System.out.printf("%s -> %s\n",stringIntegerEntry.getKey(),stringIntegerEntry.getValue());
        }

    }
}
