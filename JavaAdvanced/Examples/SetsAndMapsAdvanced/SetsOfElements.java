package JavaAdvanced.Examples.SetsAndMapsAdvanced;
import java.util.*;
import java.util.stream.Collectors;

public class SetsOfElements {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Integer>Sizes = Arrays.stream(scanner.nextLine().split(" ")).map(Integer::parseInt).collect(Collectors.toList());
        int LengthOfFirstSet = Sizes.get(0);
        int LengthOfSecondSet = Sizes.get(1);
        LinkedHashSet<Integer> n = new LinkedHashSet<>();
        while(LengthOfFirstSet-->0){
            int Number = Integer.parseInt(scanner.nextLine());
            n.add(Number);
        }
        LinkedHashSet<Integer> m = new LinkedHashSet<>();
        while(LengthOfSecondSet-->0){
            int Number = Integer.parseInt(scanner.nextLine());
            m.add(Number);
        }
        LinkedHashSet<Integer>RepeatingElements = new LinkedHashSet<>();
        n.forEach(a->{
            if (m.contains(a)) {
                RepeatingElements.add(a);
            }
        });

        System.out.println(RepeatingElements.stream().map(String::valueOf).collect(Collectors.joining(" ")));
    }
}
