
package JavaOOP.Exercises.Abstraction.greedyTimes;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        long capacity = Long.parseLong(scanner.nextLine());
        String[] inputToSplit = scanner.nextLine().split("\\s+");

        Bag bag = new Bag(capacity);

        for (int i = 0; i < inputToSplit.length; i += 2) {
            String nameOfStolenItem = inputToSplit[i];
            long SizeOfStolenItem = Long.parseLong(inputToSplit[i + 1]);

            if (bag.getCapacity() < bag.getTotalSumOfAll() + SizeOfStolenItem) {
                continue;
            }
            if (nameOfStolenItem.length() == 3) {
                if (bag.getTotalCash()==0) {
                    if (bag.getTotalGems()>0 && SizeOfStolenItem > bag.getTotalGold()) {
                            continue;
                    } else if(bag.getTotalGems()<=0){
                        continue;
                    }
                } else if (bag.getTotalCash() + SizeOfStolenItem > bag.getTotalGems()) {
                    continue;
                }
                bag.addCash(nameOfStolenItem, SizeOfStolenItem);
            } else if (nameOfStolenItem.toLowerCase().endsWith("gem")) {
                if (bag.getTotalGems()==0) {
                    if (bag.getTotalGold()>0 && SizeOfStolenItem > bag.getTotalGold()) {
                            continue;
                    } else if(bag.getTotalGold()<=0){
                        continue;
                    }
                } else if (bag.getTotalGems() + SizeOfStolenItem > bag.getTotalGold()) {
                    continue;
                }
                bag.addGem(nameOfStolenItem, SizeOfStolenItem);
            } else if (nameOfStolenItem.equalsIgnoreCase("gold")) {
                bag.addGold(nameOfStolenItem, SizeOfStolenItem);
            }
        }

        bag.Print();
    }
}