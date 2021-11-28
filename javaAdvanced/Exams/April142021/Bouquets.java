package Exams.April142021;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Scanner;

public class Bouquets {
    public static void main(String[] args) {
        ArrayDeque<Integer> daffodils = new ArrayDeque<>();
        Scanner scanner = new Scanner(System.in);
        Arrays.stream(scanner.nextLine().split(", "))
                .mapToInt(Integer::parseInt).forEach(daffodils::offer);

        ArrayDeque<Integer> tulips = new ArrayDeque<>();
        Arrays.stream(scanner.nextLine().split(", "))
                .mapToInt(Integer::parseInt).forEach(tulips::push);
        int Flowers = 0;
        int StoredSum = 0;
        while(!daffodils.isEmpty() && !tulips.isEmpty()) {
            int LastTulips = tulips.pop();
            int FirstDaffodils = daffodils.poll();
            int Sum = FirstDaffodils+LastTulips;
            if (Sum==15) {
                Flowers++;
            }else if(Sum>15){
                while(true){
                    Sum-=2;
                    if(Sum==15){
                        Flowers++;
                        break;
                    }else if(Sum<15){
                        StoredSum+=Sum;
                        break;
                    }
                }
            }else{
                StoredSum+=Sum;
            }
        }

        Flowers+=StoredSum/15;
        if(Flowers>=5){
            System.out.printf("You made it! You go to the competition with %s bouquets!",Flowers);
        }else{
            System.out.printf("You failed... You need more %s bouquets.",5-Flowers);
        }
    }
}
