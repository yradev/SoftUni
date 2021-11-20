package DefiningClasses.Google;

import javax.xml.crypto.Data;
import java.util.*;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Map<String,Information>DataBase = new LinkedHashMap<>();
        while(true){
            List<String>Input = Arrays.stream(scanner.nextLine().split(" ")).collect(Collectors.toList());
            if(Input.get(0).equals("End")){
                break;
            }
            String Name = Input.get(0);
            String InformationToStoreIn = Input.get(1);
            Information Saver = new Information();
            if(!DataBase.containsKey(Name)){
                DataBase.put(Name,Saver);
            }

            switch (InformationToStoreIn){
                case"company":
                    String CompanyName = Input.get(2);
                    String Departmant = Input.get(3);
                    double Salary =Double.parseDouble(Input.get(4));
                        DataBase.get(Name).setCompany(CompanyName, Departmant, Salary);
                    break;
                case"pokemon":
                    String PokemonName = Input.get(2);
                    String PokemonType = Input.get(3);
                    DataBase.get(Name).setPokemon(PokemonName,PokemonType);
                    break;
                case"parents":
                    String ParentName = Input.get(2);
                    String ParentBirthday = Input.get(3);
                    DataBase.get(Name).setParent(ParentName,ParentBirthday);
                    break;
                case"children":
                    String ChildName = Input.get(2);
                    String ChildBirthday = Input.get(3);
                    DataBase.get(Name).setChildren(ChildName,ChildBirthday);
                    break;
                case"car":
                    String Model = Input.get(2);
                    int Speed = Integer.parseInt(Input.get(3));
                        DataBase.get(Name).setCar(Model, Speed);
                    break;
            }
        }

        String Name = scanner.nextLine();
        System.out.printf("%s\n",Name);
        DataBase.get(Name).getText();
    }
}
