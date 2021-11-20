package MultidimensionalArrays;
import java.util.*;
import java.util.stream.Collectors;

public class MatrixOfPalindromes {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String Letters = "abcdefghijklmnopqrstuvwxyz";

        List<Integer>Split = Arrays.stream(scanner.nextLine().split(" ")).map(Integer::parseInt).collect(Collectors.toList());
        int Rows = Split.get(0);
        int Cols = Split.get(1);

        int [][]Matrix = new int[Rows][Cols];
        int index=0;
        int middleIndex=0;
        for(int i=0;i<Matrix.length;i++){
            for(int a=0;a<Matrix[i].length;a++){
                System.out.printf("%s%s%s ",Letters.charAt(index),Letters.charAt(middleIndex),Letters.charAt(index));
                middleIndex++;
            }
            index++;
            middleIndex=index;
            System.out.println();
        }

    }
}
