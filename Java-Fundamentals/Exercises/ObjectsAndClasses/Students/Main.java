package bgStudent;
import java.util.*;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        List<Students>students = new ArrayList<>();

        int n = Integer.parseInt(input.nextLine());

        for(int i=0;i<n;i++){
            List<String>Split = Arrays.stream(input.nextLine().split(" ")).collect(Collectors.toList());
            String FirstName = Split.get(0);
            String LastName = Split.get(1);
            double Grade = Double.parseDouble(Split.get(2));

            Students std = new Students(FirstName,LastName,Grade);

            students.add(std);
        }

        List<Students>end = new ArrayList<>();
        end=students.stream()
                .sorted(Comparator.comparingDouble(a->a.Grade))
                .collect(Collectors.toList());

        Collections.reverse(end);
        for (Students student : end) {
            System.out.println(student);
        }

    }
}
