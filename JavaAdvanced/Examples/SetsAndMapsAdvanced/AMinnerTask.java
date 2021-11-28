package JavaAdvanced.Examples.SetsAndMapsAdvanced;
import java.util.*;
public class AMinnerTask {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String Input = scanner.nextLine();
        Map<String,Integer>DataBase = new LinkedHashMap<>();
        int Count = 0;
        String SavedName = "";
        while(!Input.equals("stop")){
            Count++;
            if(Count%2==0){
                int newValue = DataBase.get(SavedName)+Integer.parseInt(Input);
                DataBase.put(SavedName,newValue);
            }else{
                SavedName = Input;
                DataBase.putIfAbsent(Input,0);
            }
            Input = scanner.nextLine();
        }
        DataBase.forEach((key, value) -> System.out.printf("%s -> %s\n",key,value));
    }
}
