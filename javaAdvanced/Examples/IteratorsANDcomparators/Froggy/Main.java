package IteratorsANDcomparators.Froggy;

import java.util.*;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Integer>Input = Arrays.stream(scanner.nextLine().split(", ")).map(Integer::parseInt).collect(Collectors.toList());
        Lake lake = new Lake(Input);

        List<Integer>OutPut = new ArrayList<>();

        for (Integer FrogStep : lake) {
            OutPut.add(FrogStep);
        }

        System.out.println(OutPut.stream().map(String::valueOf).collect(Collectors.joining(", ")));

    }
}
