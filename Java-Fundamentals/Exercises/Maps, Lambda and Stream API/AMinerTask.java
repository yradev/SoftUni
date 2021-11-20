package Maps;

import java.util.*;

public class AMinerTask {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        Map <String,Integer>Sequences = new LinkedHashMap<>();
        String tempKey = "";
        int Count = 0;
        while(true){
            String Input = input.nextLine();
            Count++;
            if(Input.equalsIgnoreCase("Stop")){
                break;
            }

            if(Count%2!=0){
                tempKey=Input;
            }else{
                if(!Sequences.containsKey(tempKey)){
                    Sequences.put(tempKey,Integer.parseInt(Input));
                }else{
                    Sequences.put(tempKey,Sequences.get(tempKey)+Integer.parseInt(Input));
                }
            }
        }

        for (Map.Entry<String, Integer> stringIntegerEntry : Sequences.entrySet()) {
            System.out.printf("%s -> %s\n",stringIntegerEntry.getKey(),stringIntegerEntry.getValue());
        }

    }
}
