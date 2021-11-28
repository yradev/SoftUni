package SetsAndMapsAdvanced;
import java.util.*;
import java.util.stream.Collectors;

public class PhoneBook {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Map<String,String>PhoneBook = new LinkedHashMap<>(ImportBook(scanner));
        String Input=scanner.nextLine();
        while(!Input.equals("stop")){
            if(PhoneBook.containsKey(Input)){
                System.out.printf("%s -> %s\n",Input,PhoneBook.get(Input));
            }else{
                System.out.printf("Contact %s does not exist.\n",Input);
            }
            Input=scanner.nextLine();
        }
    }

    private static Map<String,String> ImportBook(Scanner scanner) {
        Map<String, String> PhoneBook = new LinkedHashMap<>();
        String Input = scanner.nextLine();
        while(!Input.equals("search")){
            List<String>Split = Arrays.stream(Input.split("-")).collect(Collectors.toList());
            String Name = Split.get(0);
            String Number = Split.get(1);
            PhoneBook.put(Name,Number);
            Input = scanner.nextLine();
        }
        return PhoneBook;
    }
}
