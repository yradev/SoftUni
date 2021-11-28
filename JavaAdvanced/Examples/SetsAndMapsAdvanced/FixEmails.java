package JavaAdvanced.Examples.SetsAndMapsAdvanced;
import java.util.*;
public class FixEmails {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int Count = 1;
        Map<String,String>Emails = new LinkedHashMap<>();
        String LastName = "";
        while(true){
            String Input = scanner.nextLine();
            if(Input.equals("stop")){
                break;
            }
            if(Count%2!=0){
                Emails.put(Input,"");
                LastName=Input;
            }else{
                Emails.put(LastName,Input);
            }
            Count++;
        }

        Emails.entrySet().stream()
                .filter(a-> !a.getValue().contains(".us") && !a.getValue().contains(".uk") && !a.getValue().contains(".com"))
                .forEach(a-> System.out.printf("%s -> %s\n",a.getKey(),a.getValue()));
    }
}
