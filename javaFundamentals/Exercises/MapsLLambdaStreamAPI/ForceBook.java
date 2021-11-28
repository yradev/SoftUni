package javaFundamentals.Exercises.MapsLLambdaStreamAPI;

import java.util.*;
import java.util.stream.Collectors;


public class ForceBook {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        Map <String,String> FroceUsers = new LinkedHashMap<>();
        while(true){
            String Input = input.nextLine();
            if(Input.equalsIgnoreCase("Lumpawaroo")){
                break;
            }
            if(Input.contains(" | ")){
                List <String> Splitter = Arrays.stream(Input.split(" \\| ")).collect(Collectors.toList());
                String ForceSide = Splitter.get(0);
                String ForceUser = Splitter.get(1);

                if(!FroceUsers.containsKey(ForceUser)){
                    FroceUsers.put(ForceUser,ForceSide);
                }
            }else if(Input.contains(" -> ")){
                List <String> Splitter = Arrays.stream(Input.split(" -> ")).collect(Collectors.toList());
                String ForceUser = Splitter.get(0);
                String ForceSide = Splitter.get(1);
                FroceUsers.put(ForceUser,ForceSide);
                System.out.printf("%s joins the %s side!\n",ForceUser,ForceSide);
            }
        }

        Map<String,List<String>>newUsers = new LinkedHashMap<>();
        for (Map.Entry<String, String> stringStringEntry : FroceUsers.entrySet()) {
            if(!newUsers.containsKey(stringStringEntry.getValue())){
                newUsers.put(stringStringEntry.getValue(),new ArrayList<>());
                newUsers.get(stringStringEntry.getValue()).add(stringStringEntry.getKey());
            }else{
                newUsers.get(stringStringEntry.getValue()).add(stringStringEntry.getKey());
            }
        }

        newUsers = newUsers.entrySet().stream()
                .sorted((e1, e2) -> {
                    int sortedResult = Integer.compare(e2.getValue().size(), e1.getValue().size());
                    if (sortedResult == 0) {
                        sortedResult = e1.getKey().compareTo(e2.getKey());
                    }
                    return sortedResult;})
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue, (e1, e2) -> e1, LinkedHashMap::new));

        for (Map.Entry<String, List<String>> stringListEntry : newUsers.entrySet()) {
            if(!newUsers.get(stringListEntry.getKey()).isEmpty()) {
                System.out.printf("Side: %s, Members: %s\n", stringListEntry.getKey(), newUsers.get(stringListEntry.getKey()).size());
                Collections.sort(newUsers.get(stringListEntry.getKey()));
            }
            for(int i=0;i<=newUsers.get(stringListEntry.getKey()).size()-1;i++){
                System.out.printf("! %s\n",newUsers.get(stringListEntry.getKey()).get(i));
            }
        }
    }
}
