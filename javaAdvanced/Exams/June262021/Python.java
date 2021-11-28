package Exams.June262021;
import java.util.*;

public class Python {
    public static int PythonLength=1;
    public static int CountFoods = 1;
    public static int PlayerRow;
    public static int PlayerCol;
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int Length = Integer.parseInt(scanner.nextLine());
        char[][] Matrix = new char[Length][Length];
        String[] Moves = scanner.nextLine().split(", ");


        for (int r = 0; r < Length; r++) {
            String[] currentCol = scanner.nextLine().split("\\s+");
            for (int c = 0; c < currentCol.length; c++) {
                Matrix[r][c] = currentCol[c].charAt(0);
            }
        }
        for (int r = 0; r < Matrix.length; r++) {
            for (int c = 0; c < Matrix[r].length; c++) {
                if (Matrix[r][c] == 's') {
                    PlayerRow = r;
                    PlayerCol = c;
                }
                if (Matrix[r][c] == 'f') {
                    CountFoods++;
                }
            }
        }
        boolean isFinished = false;
        for(String Move : Moves){
            switch(Move){
                case"left":
                    isFinished = MoveSnake(PlayerRow,PlayerCol-1,PlayerRow,Matrix.length-1, Matrix);
                    break;
                case"right":
                    isFinished = MoveSnake(PlayerRow,PlayerCol+1,PlayerRow,0,Matrix);
                    break;
                case"up":
                    isFinished=MoveSnake(PlayerRow-1,PlayerCol,Matrix.length-1,PlayerCol,Matrix);
                    break;
                case"down":
                    isFinished=MoveSnake(PlayerRow+1,PlayerCol,0,PlayerCol,Matrix);
                    break;
            }

            if(isFinished || CountFoods==PythonLength){
                String result = CountFoods == PythonLength
                        ? String.format("You win! Final python length is %d", PythonLength)
                        : "You lose! Killed by an enemy!";
                System.out.println(result);
                return;
            }
        }
        System.out.printf("You lose! There is still %s food to be eaten.",CountFoods-PythonLength);
    }

    private static boolean MoveSnake(int playerRow, int playerCol, int OldOfBoundsRow, int noldOfBoundsCol, char[][] matrix) {
        if(playerRow<0 || playerRow>=matrix.length || playerCol<0 || playerCol>=matrix.length){
            matrix[PlayerRow][PlayerCol]='*';
            char Symbol = matrix[OldOfBoundsRow][noldOfBoundsCol];
            if(Symbol == 'e'){
                return true;
            }else{
                if(Symbol == 'f'){
                    PythonLength++;
                }

                PlayerRow=OldOfBoundsRow;
                PlayerCol=noldOfBoundsCol;
            }
        }else{
            char Symbol = matrix[playerRow][playerCol];
            if(Symbol == 'e'){
                return true;
            }else{
                if(Symbol == 'f'){
                    PythonLength++;
                }
                matrix[PlayerRow][PlayerCol]='*';
                PlayerRow=playerRow;
                PlayerCol=playerCol;
            }
        }
        return false;
    }
}
