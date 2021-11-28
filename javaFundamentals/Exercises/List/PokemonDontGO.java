package List;

import java.util.*;
import java.util.stream.Collectors;

public class PokemonDontGO {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        List<Integer> Sequence = Arrays.stream(input.nextLine().split(" ")).map(Integer::parseInt).collect(Collectors.toList());
        int SavedSum =0;
        while(!Sequence.isEmpty()){
            int Input=Integer.parseInt(input.nextLine());
            int RemovedElement = getRemovdElement(Sequence, Input);
            SavedSum+=RemovedElement;
            for(int i=0;i<=Sequence.size()-1;i++){
                int tempValue=Sequence.get(i);

                if(tempValue<=RemovedElement){
                    tempValue+=RemovedElement;
                }else{
                    tempValue-=RemovedElement;
                }

                Sequence.set(i,tempValue);
            }
        }
        System.out.println(SavedSum);
    }

    private static int getRemovdElement(List<Integer> sequence, int input) {
        int RemovedElement;
        if(input <0){
            RemovedElement= sequence.get(0);
            sequence.remove(0);
            int tmpValue = sequence.get(sequence.size()-1);
            sequence.add(0,tmpValue);
        }else if(input >=sequence.size()){
            RemovedElement= sequence.get(sequence.size()-1);
            sequence.remove(sequence.size()-1);
            sequence.add(sequence.get(0));
        }else{
            RemovedElement= sequence.get(input);
            sequence.remove(input);
        }
        return RemovedElement;
    }
}
