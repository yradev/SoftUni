package Arrays;

import java.util.*;
import java.util.stream.Collectors;

public class EqualSums {
    public static void main(String[] args) {
        Scanner Input = new Scanner(System.in);
        List<Integer> Array = Arrays.stream(Input.nextLine().split(" ")).map(Integer::parseInt).collect(Collectors.toList());

        for (int i = 0; i <= Array.size() - 1; i++) {
            int LeftSum =0;
            int RightSum =0;

            for(int b=0; b<i;b++){
                LeftSum+=Array.get(b);
            }

            for(int c=i+1; c<=Array.size()-1;c++){
                RightSum+=Array.get(c);
            }

            if(LeftSum==RightSum){
                System.out.println(i);
                return;
            }
        }

        System.out.println("no");
    }

}
