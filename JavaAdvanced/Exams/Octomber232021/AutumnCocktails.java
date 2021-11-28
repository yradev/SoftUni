package JavaAdvanced.Exams.Octomber232021;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Scanner;

public class AutumnCocktails {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int PearSour = 0;
        int TheHarvest = 0;
        int AppleHinny = 0;
        int HighFashion = 0;
        ArrayDeque <Integer> SingleBucket = new ArrayDeque<>();
        ArrayDeque <Integer> FreshnesLevel= new ArrayDeque<>();

        Arrays.stream(scanner.nextLine().split("\\s+")).map(Integer::parseInt).forEach(SingleBucket::offer);
        Arrays.stream(scanner.nextLine().split("\\s+")).map(Integer::parseInt).forEach(FreshnesLevel::push);

        while(!SingleBucket.isEmpty() && !FreshnesLevel.isEmpty()) {
            int FirstBucket = SingleBucket.poll();
            int LastLevel = FreshnesLevel.pop();
            if(FirstBucket==0){
                FreshnesLevel.push(LastLevel);
                continue;
            }
            int Mix = FirstBucket*LastLevel;

            switch (Mix) {
                case 150:
                    PearSour++;
                    break;
                case 250:
                    TheHarvest++;
                    break;
                case 300:
                    AppleHinny++;
                    break;
                case 400:
                    HighFashion++;
                    break;
                default:
                    SingleBucket.offerLast(FirstBucket + 5);
                    break;
            }
        }

    boolean isTrue = PearSour > 0 && TheHarvest > 0 && AppleHinny > 0 && HighFashion > 0;

        if(isTrue){
            System.out.println("It's party time! The cocktails are ready!");
        }else{
            System.out.println("What a pity! You didn't manage to prepare all cocktails.");
        }

        if(!SingleBucket.isEmpty()) {
            System.out.printf("Ingredients left: %s\n", SingleBucket.stream().mapToInt(Integer::intValue).sum());
        }

        if(AppleHinny>0){
            System.out.printf(" # Apple Hinny --> %s\n",AppleHinny);
        }
        if(HighFashion>0){
            System.out.printf(" # High Fashion --> %s\n",HighFashion);
        }
        if(PearSour>0){
            System.out.printf(" # Pear Sour --> %s\n",PearSour);
        }
        if(TheHarvest>0){
            System.out.printf(" # The Harvest --> %s\n",TheHarvest);
        }

    }
}
