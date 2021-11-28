package JavaOOP.Exercises.Abstraction.greedyTimes;

import java.util.ArrayList;
import java.util.List;

public class Bag {
    private long capacity;
    private long totalGold;
    private long totalCash;
    private long totalGems;
    private List<Gems> gemsList;
    private List<Cash> cashList;
    private List<Gold> goldList;

    public Bag(long capacity) {
        this.capacity = capacity;
        gemsList = new ArrayList<>();
        cashList = new ArrayList<>();
        goldList = new ArrayList<>();
    }

    public long getCapacity() {
        return capacity;
    }

    public long getTotalSumOfAll(){
        return totalCash+totalGems+totalGold;
    }

    public long getTotalGold() {
        return totalGold;
    }

    public long getTotalCash() {
        return totalCash;
    }

    public long getTotalGems() {
        return totalGems;
    }

    public void addGold(String name, long sizeOfStolenThing) {
        boolean haveGoldWithThisName = false;
        for (Gold gold : goldList) {
            if(gold.getName().equals(name)){
                gold.setSize(gold.getSize()+sizeOfStolenThing);
                totalGold += sizeOfStolenThing;
                haveGoldWithThisName=true;
                break;
            }
        }

        if(!haveGoldWithThisName) {
            Gold gold = new Gold(name, sizeOfStolenThing);
            goldList.add(gold);
            totalGold += sizeOfStolenThing;
        }
    }

    public void addGem(String name, long sizeOfStolenThing) {
        boolean HaveGemWithThisName = false;
        for (Gems gem : gemsList) {
            if(gem.getName().equals(name)){
                gem.setSize(gem.getSize()+sizeOfStolenThing);
                totalGems += sizeOfStolenThing;
                HaveGemWithThisName=true;
                break;
            }
        }

        if(!HaveGemWithThisName) {
            Gems gem = new Gems(name, sizeOfStolenThing);
            gemsList.add(gem);
            totalGems += sizeOfStolenThing;
        }
    }


    public void addCash(String name, long sizeOfStolenThing) {
        boolean HaveCashWithThisName = false;
        for (Cash cash : cashList) {
            if(cash.getName().equals(name)){
                cash.setSize(cash.getSize()+sizeOfStolenThing);
                totalCash += sizeOfStolenThing;
                HaveCashWithThisName=true;
                break;
            }
        }

        if(!HaveCashWithThisName) {
            Cash cash = new Cash(name, sizeOfStolenThing);
            cashList.add(cash);
            totalCash += sizeOfStolenThing;
        }
    }

    public void Print() {
        if(totalGold!=0){
            System.out.printf("<Gold> $%s\n",totalGold);
            goldList.stream().sorted((e1, e2) -> e2.getName().compareTo(e1.getName())).forEach(i -> System.out.println("##" + i.getName() + " - " + i.getSize()));
        }
        if(totalGems!=0) {
            System.out.printf("<Gem> $%s\n",totalGems);
            gemsList.stream().sorted((e1, e2) -> e2.getName().compareTo(e1.getName())).forEach(i -> System.out.println("##" + i.getName() + " - " + i.getSize()));
        }
        if(totalCash!=0) {
            System.out.printf("<Cash> $%s\n",totalCash);
            cashList.stream().sorted((e1, e2) -> e2.getName().compareTo(e1.getName())).forEach(i -> System.out.println("##" + i.getName() + " - " + i.getSize()));
        }
    }
}
