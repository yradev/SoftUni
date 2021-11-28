package JavaAdvanced.Examples.SetsAndMapsAdvanced;

import java.util.*;
public class UniqueUsernames {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int Count = Integer.parseInt(scanner.nextLine());
        List<String>UserNames = new ArrayList<>();
        while(Count-->0){
            String UserName = scanner.nextLine();
            UserNames.add(UserName);
        }

        LinkedHashSet<String>UniqueUserNames = new LinkedHashSet<>(UserNames);

        UniqueUserNames.forEach(System.out::println);
    }
}
