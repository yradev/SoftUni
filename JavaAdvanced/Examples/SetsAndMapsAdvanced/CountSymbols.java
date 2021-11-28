package JavaAdvanced.Examples.SetsAndMapsAdvanced;
import java.util.*;


public class CountSymbols {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        char[] CharsSplit = scanner.nextLine().toCharArray();
        List<Character>Chars = new ArrayList<>();
        for (char aChar : CharsSplit) {
            Chars.add(aChar);
        }

        Map<Character,Integer>Count = new TreeMap<>();
        Chars.forEach(a->{
            if(!Count.containsKey(a)){
                Count.put(a,1);
            }else{
                int temp = Count.get(a)+1;
                Count.put(a,temp);
            }
        });

        Count.forEach((key, value) -> System.out.printf("%s: %s time/s\n", key, value));
    }
}
