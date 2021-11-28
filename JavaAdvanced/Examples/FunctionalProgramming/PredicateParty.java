package JavaAdvanced.Examples.FunctionalProgramming;

import java.util.*;
import java.util.function.BiPredicate;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class PredicateParty {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<String>People = Arrays.stream(scanner.nextLine().split(" ")).collect(Collectors.toList());
        BiPredicate<String,String> StartW = (a, b)->{
            boolean isValid = true;
            String Name = String.valueOf(a);
            String StartWith = String.valueOf(b);
            String NamesStart = Name.substring(0,StartWith.length());
            if(!NamesStart.equals(StartWith)){
                return false;
            }
            return isValid;
        };

        BiPredicate<String,String>EndW = (a,b)->{
            boolean isValid = true;
            String Name = String.valueOf(a);
            String EndValue = String.valueOf(b);
            String NameStream = Name.substring((Name.length()-EndValue.length()));
            if(!NameStream.equals(EndValue)){
                return false;
            }
            return isValid;
        };

        BiPredicate<String,Integer>LengthW = (a,b)->{
            boolean isValid = true;
            String Name = String.valueOf(a);
            int Length = Integer.parseInt(String.valueOf(b));
            if(Name.length()!=Length){
                return false;
            }
            return isValid;
        };

        Function<Stream<String>,String> End = a->a
                .map(String::valueOf)
                .sorted(String::compareTo)
                .collect(Collectors.joining(", "));

        while(true){
            String Input = scanner.nextLine();
            if(Input.equals("Party!")){
                break;
            }
            List<String>Split = Arrays.stream(Input.split(" ")).collect(Collectors.toList());
            String Command = Split.get(0);
            String Condition = Split.get(1);

            switch (Command){
                case"Double":
                    boolean isDoubled = false;
                    if(Condition.equals("StartsWith")){
                        String FirstPart = Split.get(2);
                        for (int i=0;i<People.size();i++) {
                            if(i>0){
                                if(isDoubled){
                                    isDoubled=false;
                                    continue;
                                }
                            }
                            if(StartW.test(People.get(i),FirstPart)) {
                                People.add(i, People.get(i));
                                isDoubled=true;
                            }
                        }
                    }
                    if(Condition.equals("EndsWith")){
                        String EndPart = Split.get(2);
                        for (int i=0;i<People.size();i++) {
                            if(i>0){
                                if(isDoubled){
                                    isDoubled=false;
                                    continue;
                                }
                            }
                            if(EndW.test(People.get(i),EndPart)) {
                                People.add(i, People.get(i));
                                isDoubled=true;
                            }
                        }
                    }
                    if(Condition.equals("Length")){
                        int Length = Integer.parseInt(Split.get(2));
                        for (int i=0;i<People.size();i++) {
                            if(i>0){
                                if(isDoubled){
                                    isDoubled=false;
                                    continue;
                                }
                            }
                            if(LengthW.test(People.get(i),Length)) {
                                People.add(i, People.get(i));
                                isDoubled=true;
                            }
                        }
                    }
                    break;
                case"Remove":
                    if(Condition.equals("StartsWith")){
                        String StartPart = Split.get(2);
                        People.removeIf(Name->StartW.test(Name,StartPart));
                    }
                    if(Condition.equals("EndsWith")){
                        String EndPart = Split.get(2);
                        People.removeIf(Name->EndW.test(Name,EndPart));
                    }
                    if(Condition.equals("Length")){
                        int Length = Integer.parseInt(Split.get(2));
                        People.removeIf(Name->LengthW.test(Name,Length));
                    }
                    break;
            }
        }

        if(People.isEmpty()){
            System.out.println("Nobody is going to the party!");
        }else {
            System.out.printf("%s are going to the party!", End.apply(People.stream()));
        }
    }
}
