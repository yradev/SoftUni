package MultidimensionalArrays;
import java.util.*;
import java.util.stream.Collectors;

public class MaximalSum {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Integer>Split = Arrays.stream(scanner.nextLine().split(" ")).map(Integer::parseInt).collect(Collectors.toList());
        int Rows = Split.get(0);
        int Cols = Split.get(1);

        int [][]Matrix = new int[Rows][Cols];

        for (int i=0; i<Matrix.length;i++){
            int [] Array = Arrays.stream(scanner.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            Matrix[i]=Array;
        }
        int SavedSum = 0;
        int [] [] SavedArray = new int[3][3];
        int RowFirstIndex = 0;
        int RowLastIndex = 2;
        int ColFirstIndex = 0;
        int ColLastIndex = 2;
        while(true){
            int sum=0;
            int [][] tempArray = new int[3][3];
            int IndexRow=0;
            int IndexCol=0;
                for (int i = RowFirstIndex; i<=RowLastIndex; i++) {
                    for (int a = ColFirstIndex; a<= ColLastIndex; a++) {
                        tempArray[IndexRow][IndexCol] = Matrix[i][a];
                        IndexCol++;
                        sum+=Matrix[i][a];
                    }
                    IndexCol=0;
                    IndexRow++;
            }
                if(ColLastIndex<Cols){
                    ColFirstIndex++;
                    ColLastIndex++;
                }

                if(ColLastIndex>=Cols){
                    RowFirstIndex++;
                    RowLastIndex++;
                    ColFirstIndex=0;
                    ColLastIndex=2;
                }
                if(sum>SavedSum){
                    SavedSum=sum;
                    SavedArray=tempArray;
                }
                if(RowLastIndex==Rows){
                    break;
                }
        }
        System.out.printf("Sum = %s\n",SavedSum);
        for(int i=0;i<SavedArray.length;i++){
            for(int a=0;a<SavedArray[i].length;a++){
                System.out.printf("%s ",SavedArray[i][a]);
            }
            System.out.println();
        }
    }
}
