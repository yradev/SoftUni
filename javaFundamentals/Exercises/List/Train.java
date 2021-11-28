package javaFundamentals.Exercises.List;


import java.util.*;
import java.util.stream.Collectors;

public class Train {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        List <Integer> VagonsAndPassangersInside = Arrays.stream(input.nextLine().split(" ")).map(Integer::parseInt).collect(Collectors.toList());
        int MaxCapacity = Integer.parseInt(input.nextLine());

        String Input = input.nextLine();

        while(!Input.equalsIgnoreCase("End")){
            String [] Split = Input.split(" ");
            if(Split[0].equalsIgnoreCase("add")){
                VagonsAndPassangersInside.add(Integer.parseInt(Split[1]));
            }else{
                int Passangers = Integer.parseInt(Input);
                for(int i=0;i<=VagonsAndPassangersInside.size()-1;i++){
                    int newValue = Passangers+VagonsAndPassangersInside.get(i);
                    if(newValue<=MaxCapacity){
                        VagonsAndPassangersInside.set(i,newValue);
                        break;
                    }
                }
            }
            Input = input.nextLine();
        }

        String EndArray = VagonsAndPassangersInside.stream().map(String::valueOf) .collect(Collectors.joining(" "));
        System.out.println(EndArray);
    }
}
