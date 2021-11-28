package javaFundamentals.Exercises.MapsLLambdaStreamAPI;

import java.util.*;
import java.util.stream.Collectors;

public class LegendaryFarming {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        Map <String,Integer> DataBase = new LinkedHashMap<>();
        DataBase.put("shards",0);
        DataBase.put("fragments",0);
        DataBase.put("motes",0);
        Map<String,Integer>Junk = new LinkedHashMap<>();
        while(DataBase.get("shards")<250 && DataBase.get("fragments")<250 && DataBase.get("motes")<250){
            List <String> Input = Arrays.stream(input.nextLine().toLowerCase().split(" ")).collect(Collectors.toList());

            for(int i=0;i<=Input.size()-1;i+=2){
                int Quality = Integer.parseInt(Input.get(i));
                String Key = Input.get(i+1);
                switch(Key){
                    case"shards":
                    case"fragments":
                    case"motes":
                        DataBase.put(Key,DataBase.get(Key)+Quality);
                        break;
                    default:
                        if(!Junk.containsKey(Key)){
                            Junk.put(Key,Quality);
                        }else{
                            Junk.put(Key,Junk.get(Key)+Quality);
                        }
                }

                if(DataBase.get("shards")>=250 || DataBase.get("fragments")>=250 || DataBase.get("motes")>=250){
                    break;
                }
            }
        }
        if(DataBase.get("shards")>=250){
            DataBase.put("shards",DataBase.get("shards")-250);
            System.out.println("Shadowmourne obtained!");
        }
        if(DataBase.get("fragments")>=250){
            DataBase.put("fragments",DataBase.get("fragments")-250);
            System.out.println("Valanyr obtained!");
        }
        if(DataBase.get("motes")>=250){
            DataBase.put("motes",DataBase.get("motes")-250);
            System.out.println("Dragonwrath obtained!");
        }

        DataBase.entrySet().stream()
                .sorted(Map.Entry.comparingByKey())
                .sorted((a,b)->b.getValue().compareTo(a.getValue()))

                .forEach(a->System.out.printf("%s: %s\n",a.getKey(),a.getValue()));

        Junk.entrySet().stream()
                .sorted(Map.Entry.comparingByKey())
                .forEach(a->System.out.printf("%s: %s\n",a.getKey(),a.getValue()));
    }
}
