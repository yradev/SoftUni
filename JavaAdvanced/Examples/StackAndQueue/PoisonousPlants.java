package JavaAdvanced.Examples.StackAndQueue;
import java.util.*;
import java.util.stream.Collectors;

public class PoisonousPlants {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int N = Integer.parseInt(input.nextLine());
        List<Integer>PesticideList = Arrays.stream(input.nextLine().split(" ")).map(Integer::parseInt).collect(Collectors.toList());
        ArrayDeque<Integer>Pesticide = new ArrayDeque<>();
        for (Integer integer : PesticideList) {
            Pesticide.offer(integer);
        }
        int CountDays =0;
        while(true){
            int Size = Pesticide.size();
            int LastPeticide = Integer.MAX_VALUE;
            for(int a=1;a<=Size;a++){
                int CurrentPeticide = Pesticide.poll();
                if(CurrentPeticide<=LastPeticide){
                    Pesticide.offer(CurrentPeticide);
                }
                LastPeticide=CurrentPeticide;
            }
            if(Pesticide.size()==Size)
            {
                break;
            }else{
                CountDays++;
            }
        }
        System.out.println(CountDays);
    }
}
