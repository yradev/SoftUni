package Arrays;

import java.util.*;
import java.util.stream.Collectors;

public class TopIntegers {
    public static void main(String[] args) {
        Scanner Input = new Scanner(System.in);
        List<Integer> Array = Arrays.stream(Input.nextLine().split(" ")).map(Integer::parseInt).collect(Collectors.toList());

        int isfalse = 0;
        for(int i=0; i<=Array.size()-1;i++){
            for(int b=i+1; b<=Array.size()-1;b++){
                if(Array.get(i)<=Array.get(b)) {
                    isfalse=1;
                }
            }
            if(isfalse==0){
                System.out.printf("%s ",Array.get(i));
            }
            isfalse=0;
        }
    }
}
