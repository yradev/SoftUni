package MultidimensionalArrays;
import java.util.*;
import java.util.stream.Collectors;

public class DiagonalDifference {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int rows = Integer.parseInt(scanner.nextLine());
        int [][] Matrix = new int [rows][];

        for(int i=0;i<Matrix.length;i++){
            int [] Array = Arrays.stream(scanner.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            Matrix[i]=Array;
        }

        int SumOfFirstDiagonals = getSumOfFirstDiagonals(Matrix);
        int SumOfSecondiagonals = getSumOfSecondDiagonals(Matrix);

        System.out.println(Math.abs(SumOfFirstDiagonals-SumOfSecondiagonals));

    }

    private static int getSumOfSecondDiagonals(int[][] Matrix) {
        int Sum =0;
        int Index=Matrix.length-1;
        for(int i=0;i<Matrix.length;i++){
            Sum+=Matrix[i][Index];
            Index--;
        }
        return Sum;
    }

    private static int getSumOfFirstDiagonals(int[][] Matrix) {
        int Sum =0;
        int Index=0;
        for(int i=0;i<Matrix.length;i++){
            Sum+=Matrix[i][Index];
            Index++;
        }
        return Sum;
    }
}
