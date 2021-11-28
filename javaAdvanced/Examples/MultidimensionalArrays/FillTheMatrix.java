package MultidimensionalArrays;
import java.util.*;
import java.util.stream.Collectors;

public class FillTheMatrix {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<String>Conditions = Arrays.stream(scanner.nextLine().split(", ")).collect(Collectors.toList());
        int Size = Integer.parseInt(Conditions.get(0));
        String Pattern = Conditions.get(1);
        int [][] Matrix = new int [Size][Size];
        int Number=1;
        int LastNumber=1;
        if(Pattern.equals("A")){
            Matrix = getMatrixA(Size, Number, LastNumber);
        }else if(Pattern.equals("B")){
            Matrix = getMatrixB(Size, Number, LastNumber);
        }

        for(int i=0;i<Matrix.length;i++){
            for(int a=0;a<Matrix[i].length;a++){
                System.out.printf("%s ",Matrix[i][a]);
            }
            System.out.println();
        }
    }

    private static int[][] getMatrixB(int Size, int Number, int LastNumber) {
        int [][]Matrix = new int[Size][Size];
        for(int i = 0; i< Matrix.length; i++){
            List<Integer>NumbersArray = new ArrayList<>();
            NumbersArray.add(LastNumber);
            for(int a = 1; a<Size; a++){
                int tempNumber = LastNumber+Size;
                LastNumber=tempNumber;
                NumbersArray.add(tempNumber);
            }
            Number++;
            LastNumber=Number;
            for(int a = 0; a< Matrix[i].length; a++){
                Matrix[i][a]=NumbersArray.get(a);
            }
        }

        int tempSize = Matrix.length/2;
        int Index=1;
        for(int i=1;i<=tempSize;i++){
            List<Integer> tempArray = new ArrayList<>();
            for (int b = 0; b < Size; b++) {
                tempArray.add(Matrix[b][Index]);
            }
            Collections.reverse(tempArray);
            for (int b = 0; b < Size; b++) {
                Matrix[b][Index] = tempArray.get(b);
            }
            Index+=2;
        }
        return Matrix;
    }

    private static int[][] getMatrixA(int Size, int Number, int LastNumber) {
        int [][]Matrix = new int[Size][Size];
        for(int i = 0; i< Matrix.length; i++){
            List<Integer>NumbersArray = new ArrayList<>();
            NumbersArray.add(LastNumber);
            for(int a = 1; a<Size; a++){
                int tempNumber = LastNumber+Size;
                LastNumber=tempNumber;
                NumbersArray.add(tempNumber);
            }

            Number++;
            LastNumber=Number;
            for(int a = 0; a< Matrix[i].length; a++){
                Matrix[i][a]=NumbersArray.get(a);
            }
        }
        return Matrix;
    }
}
