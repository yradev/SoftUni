package JavaAdvanced.Examples.Generics.GenericSwapMethodIntiger;

import java.util.*;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N = Integer.parseInt(scanner.nextLine());
        DataBase<Integer> dataBase = new DataBase<>();
        while(N-->0){
            int Input = Integer.parseInt(scanner.nextLine());
            dataBase.add(Input);
        }

        List<Integer>Input = Arrays.stream(scanner.nextLine().split(" ")).map(Integer::parseInt).collect(Collectors.toList());
        int Index1 = Input.get(0);
        int Index2 = Input.get(1);
        dataBase.swap(Index1,Index2);

        System.out.println(dataBase);
    }
}
