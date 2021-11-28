package SetsAndMapsAdvanced;

import java.util.*;
import java.util.stream.Collectors;

public class PeriodicTable {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int Count = Integer.parseInt(scanner.nextLine());
        TreeSet<String> ChemicalElements = new TreeSet<>();
        while (Count-- > 0) {
            List<String> tempValues = Arrays.stream(scanner.nextLine().split(" ")).collect(Collectors.toList());
            ChemicalElements.addAll(tempValues);
        }

        System.out.println(String.join(" ",ChemicalElements));
    }
}
