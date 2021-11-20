package Maps;

import java.util.*;
import java.util.stream.Collectors;

public class Courses {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        Map<String,List<String>> Courses = new LinkedHashMap<>();

        while(true){
            List<String>Input = Arrays.stream(input.nextLine().split(" : ")).collect(Collectors.toList());
            if(Input.get(0).equalsIgnoreCase("end")) {
                break;
            }

            String Course = Input.get(0);
            String Student= Input.get(1);

            if(!Courses.containsKey(Course)){
                Courses.put(Course,new ArrayList<>());
                Courses.get(Course).add(Student);
            }else{
                Courses.get(Course).add(Student);
            }
        }

        Courses = Courses.entrySet().stream()
                .sorted((a,b)->Integer.compare(b.getValue().size(),a.getValue().size()))
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue, (e1, e2) -> e1, LinkedHashMap::new));
        for (Map.Entry<String, List<String>> stringListEntry : Courses.entrySet()) {
            System.out.printf("%s: %s\n",stringListEntry.getKey(),Courses.get(stringListEntry.getKey()).size());
            Collections.sort(Courses.get(stringListEntry.getKey()));
            for(int i=0;i<=stringListEntry.getValue().size()-1;i++){
                System.out.printf("-- %s\n",stringListEntry.getValue().get(i));
            }
        }
    }
}
