package JavaFundamentals.Exercises.Arrays;

import java.util.*;
import java.util.stream.Collectors;

public class ZigZagArrays {
    public static void main(String[] args) {
        Scanner Input = new Scanner(System.in);
        int N = Integer.parseInt(Input.nextLine());
        List <Integer> Array1 = new ArrayList<>();
        List <Integer> Array2 = new ArrayList<>();
        for (int i=1;i<=N;i++){
            List <Integer> Nums = Arrays.stream(Input.nextLine().split(" ")).map(Integer::parseInt).collect(Collectors.toList());
            if(i%2!=0) {
                Array1.add(Nums.get(0));
                Array2.add(Nums.get(1));
            }else{
                Array1.add(Nums.get(1));
                Array2.add(Nums.get(0));
            }
        }

        String String1 = Array1.stream()
                .map(String::valueOf)
                .collect(Collectors.joining(" "));

        String String2 = Array2.stream()
                .map(String::valueOf)
                .collect(Collectors.joining(" "));

        System.out.println(String1);
        System.out.println(String2);

    }
}
