package MultidimensionalArrays;
import java.util.*;
import java.util.stream.Collectors;

public class MatrixShuffling {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Integer>Split = Arrays.stream(scanner.nextLine().split(" ")).map(Integer::parseInt).collect(Collectors.toList());
        int Row = Split.get(0);
        int Col = Split.get(1);

        String [][] Matrix = new String[Row][Col];

        for(int i=0;i<Row;i++){
            String [] Array = scanner.nextLine().split(" ");
            Matrix[i]=Array;
        }

        while(true){
            String[]Input=scanner.nextLine().split(" ");

            if(Input[0].equals("END")){
                break;
            }

            if(Input[0].equals("swap") && Input.length==5){
                int oldRow = Integer.parseInt(Input[1]);
                int oldCol = Integer.parseInt(Input[2]);
                int newRow = Integer.parseInt(Input[3]);
                int newCol = Integer.parseInt(Input[4]);

                if(oldRow>=0 && oldRow<Row && oldCol>=0 && oldCol<Col && newRow>=0 && newRow < Row && newCol>=0 && newCol<Col){
                    String tempValue = Matrix[oldRow][oldCol];
                    Matrix[oldRow][oldCol]=Matrix[newRow][newCol];
                    Matrix[newRow][newCol]=tempValue;
                    for(int i=0;i<Matrix.length;i++){
                        for(int a=0;a<Matrix[i].length;a++){
                            System.out.printf("%s ",Matrix[i][a]);
                        }
                        System.out.println();
                    }
                }else{
                    System.out.println("Invalid input!");
                }
            }else{
                System.out.println("Invalid input!");
            }
        }
    }
}
