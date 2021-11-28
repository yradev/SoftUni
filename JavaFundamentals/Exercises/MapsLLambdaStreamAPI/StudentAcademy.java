package JavaFundamentals.Exercises.MapsLLambdaStreamAPI;

import java.util.*;
import java.util.stream.Collectors;

public class StudentAcademy {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        Map<String,Double>Students = new LinkedHashMap<>();
        int n = Integer.parseInt(input.nextLine());
        for(int i=0;i<n;i++){
            String Name = input.nextLine();
            double Grade = Double.parseDouble(input.nextLine());

            if(!Students.containsKey(Name)){
                Students.put(Name,Grade);
            }else{
                double tempAverage = (Students.get(Name)+Grade)/2;
                Students.put(Name,tempAverage);
            }
        }

        Students = Students.entrySet().stream()
                .sorted((a,b)->b.getValue().compareTo(a.getValue()))
                .filter(a->a.getValue()>=4.50)
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue, (e1, e2) -> e1, LinkedHashMap::new));


        Students.forEach((a,b)->System.out.printf("%s -> %.2f\n",a,b));
    }
}
