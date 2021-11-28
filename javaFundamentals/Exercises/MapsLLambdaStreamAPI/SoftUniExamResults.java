package javaFundamentals.Exercises.MapsLLambdaStreamAPI;

import java.util.*;
import java.util.stream.Collectors;

public class SoftUniExamResults {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        Map<String,List<String>> Classes = new LinkedHashMap<>();
        Map<String,Integer>PointsPerStudents = new LinkedHashMap<>();

        while(true){
            List<String>Input = Arrays.stream(input.nextLine().split("-")).collect(Collectors.toList());
            if(Input.get(0).contains("exam finished")){
                break;
            }

            String StudentName = Input.get(0);
            if(Input.get(1).equalsIgnoreCase("banned")){
                PointsPerStudents.remove(StudentName);
            }else{
                String Language = Input.get(1);
                int Points = Integer.parseInt(Input.get(2));
                if(PointsPerStudents.containsKey(StudentName)){
                    int CurrentPoints = PointsPerStudents.get(StudentName);
                    if(Points>CurrentPoints){
                        PointsPerStudents.put(StudentName,Points);
                    }
                }else{
                    PointsPerStudents.put(StudentName,Points);
                }
                if(!Classes.containsKey(Language)){
                    Classes.put(Language,new ArrayList<>());
                }

                Classes.get(Language).add(StudentName);
            }
        }
        System.out.println("Results:");
        PointsPerStudents.entrySet().stream()
                .sorted((a,b)->{
                    int Compare= b.getValue().compareTo(a.getValue());
                    if(Compare==0){
                        Compare=a.getKey().compareTo(b.getKey());
                    }
                    return Compare;
                })
                .forEach(a->System.out.printf("%s | %s\n",a.getKey(),a.getValue()));
        System.out.println("Submissions:");
        Classes.entrySet().stream()
                .sorted((a,b)->{
                    int Compare=Integer.compare(b.getValue().size(),a.getValue().size());
                    if(Compare==0){
                        Compare=a.getKey().compareTo(b.getKey());
                    }
                    return Compare;
                })
                .forEach(a->System.out.printf("%s - %s\n",a.getKey(),a.getValue().size()));
    }
}
