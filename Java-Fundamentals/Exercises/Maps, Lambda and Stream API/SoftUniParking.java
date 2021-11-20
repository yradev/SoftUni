package Maps;

import java.util.*;
import java.util.stream.Collectors;

public class SoftUniParking {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int NumberOFCommands = Integer.parseInt(input.nextLine());
        Map <String,String> License = new LinkedHashMap<>();

        for(int i=1;i<=NumberOFCommands;i++) {
            List<String> Input = Arrays.stream(input.nextLine().split(" ")).collect(Collectors.toList());
            String Command = Input.get(0);
            String UserName;
            switch (Command) {
                case "register":
                    UserName = Input.get(1);
                    String LicensePlate = Input.get(2);
                    if (!License.containsKey(UserName)) {
                        License.put(UserName, LicensePlate);
                        System.out.printf("%s registered %s successfully\n", UserName, LicensePlate);
                    } else {
                        System.out.printf("ERROR: already registered with plate number %s\n", License.get(UserName));
                    }
                    break;
                case "unregister":
                    UserName = Input.get(1);
                    if (!License.containsKey(UserName)) {
                        System.out.printf("ERROR: user %s not found\n", UserName);
                    } else{
                        License.remove(UserName);
                        System.out.printf("%s unregistered successfully\n", UserName);
                    }
                    break;
            }
        }
        License.forEach((a,b)->System.out.printf("%s => %s\n",a,b));
    }
}
