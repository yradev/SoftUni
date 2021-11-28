package JavaFundamentals.Exercises.MapsLLambdaStreamAPI;

import java.util.*;
import java.util.stream.Collectors;

public class CompanyUsers {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        Map <String,List <String>>Company = new LinkedHashMap<>();

        while(true){
            List<String>Input = Arrays.stream(input.nextLine().split(" -> ")).collect(Collectors.toList());

            if(Input.get(0).equalsIgnoreCase("end")){
                break;
            }

            String CompanyName = Input.get(0);
            String Employee = Input.get(1);

            if(!Company.containsKey(CompanyName)){
                Company.put(CompanyName,new ArrayList<>());
                Company.get(CompanyName).add(Employee);
            }else if(!Company.get(CompanyName).contains(Employee)){
                Company.get(CompanyName).add(Employee);
            }
        }

        Company = Company.entrySet().stream()
                .sorted(Map.Entry.comparingByKey())
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue, (a,b)->a, LinkedHashMap::new));

        for (Map.Entry<String, List<String>> stringListEntry : Company.entrySet()) {
            System.out.printf("%s\n",stringListEntry.getKey());
            for(int i=0;i<Company.get(stringListEntry.getKey()).size();i++){
                System.out.printf("-- %s\n",Company.get(stringListEntry.getKey()).get(i));
            }
        }


    }
}
