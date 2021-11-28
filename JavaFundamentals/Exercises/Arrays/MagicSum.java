package JavaFundamentals.Exercises.Arrays;

import java.util.*;
import java.util.stream.Collectors;

public class MagicSum {
    public static void main(String[] args) {
        Scanner Input = new Scanner(System.in);
        List<Integer> Array = Arrays.stream(Input.nextLine().split(" ")).map(Integer::parseInt).collect(Collectors.toList());
        int MagicSum = Integer.parseInt(Input.nextLine());
        int Sum;

        for (int i =0 ; i<=Array.size()-1;i++){
            for(int n=i+1;n<=Array.size()-1;n++){
                Sum=Array.get(i)+Array.get(n);

                if(MagicSum==Sum){
                    System.out.printf("%s %s\n",Array.get(i),Array.get(n));
                }
            }
        }

    }
}
