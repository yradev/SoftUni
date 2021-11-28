package JavaAdvanced.Exams.February202021;

import java.util.*;

public class MagicBox {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayDeque<Integer>FirstBox = new ArrayDeque<>();
        ArrayDeque<Integer>SecondBox = new ArrayDeque<>();
        Arrays.stream(scanner.nextLine().split("\\s+")).map(Integer::parseInt).forEach(FirstBox::offer);
        Arrays.stream(scanner.nextLine().split("\\s+")).map(Integer::parseInt).forEach(SecondBox::push);
        int CollectionOfClaimedItems = 0;
        while(!FirstBox.isEmpty() && !SecondBox.isEmpty()) {

            int FirstBoxProduct = FirstBox.poll();
            int SecondBoxProduct = SecondBox.pop();
            int sum = FirstBoxProduct + SecondBoxProduct;
            if (sum % 2 == 0) {
                CollectionOfClaimedItems+=sum;
            } else {
                FirstBox.offerFirst(FirstBoxProduct);
                FirstBox.offerLast(SecondBoxProduct);
            }


        }

        if(FirstBox.isEmpty()){
            System.out.println("First magic box is empty.");
        }

        if(SecondBox.isEmpty()){
            System.out.println("Second magic box is empty.");
        }

        if(CollectionOfClaimedItems>=90){
            System.out.printf("Wow, your prey was epic! Value: %s",CollectionOfClaimedItems);
        }else{
            System.out.printf("Poor prey... Value: %s",CollectionOfClaimedItems);
        }
    }
}
