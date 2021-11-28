package JavaAdvanced.Exams.February202021;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Bomb {
    public static int PlayerRow = 0;
    public static int PlayerCol = 0;
    public static int BombCount = 0;
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int Size = Integer.parseInt(scanner.nextLine());
        String[][]Matrix = new String[Size][Size];
        ArrayDeque<String>Commands = new ArrayDeque<>();
        Arrays.stream(scanner.nextLine().split(",")).forEach(Commands::offer);

        for(int row=0;row<Matrix.length;row++){
            List<String> Input = Arrays.stream(scanner.nextLine().split("\\s+")).collect(Collectors.toList());
            for(int col=0; col<Matrix[row].length;col++){
                Matrix[row][col]=Input.get(col);
                if(Input.get(col).equals("s")){
                    PlayerRow=row;
                    PlayerCol=col;
                }
                if(Input.get(col).equals("B")){
                    BombCount++;
                }
            }
        }

        boolean isOver = false;
        while(!Commands.isEmpty()){
            String Command = Commands.poll();
            switch (Command){
                case"up":
                    isOver = Move(PlayerRow-1,PlayerCol,Matrix);
                    break;
                case"down":
                    isOver = Move(PlayerRow+1,PlayerCol,Matrix);
                    break;
                case"left":
                    isOver=Move(PlayerRow,PlayerCol-1,Matrix);
                    break;
                case"right":
                    isOver=Move(PlayerRow,PlayerCol+1,Matrix);
                    break;
            }

            if(isOver || BombCount==0){
                if(BombCount==0){
                    System.out.println("Congratulations! You found all bombs!");
                }
                if(isOver){
                    System.out.printf("END! %s bombs left on the field",BombCount);
                }
                return;
            }
        }

        System.out.printf("%s bombs left on the field. Sapper position: (%s,%s)",BombCount,PlayerRow,PlayerCol);
    }

    private static boolean Move(int playerRow, int playerCol, String[][] matrix) {
        if(playerRow>=0 && playerRow<matrix.length && playerCol>=0 && playerCol<matrix[playerRow].length) {
            if (matrix[playerRow][playerCol].equals("B")) {
                BombCount--;
                matrix[playerRow][playerCol] = "+";
                System.out.println("You found a bomb!");
                PlayerRow = playerRow;
                PlayerCol = playerCol;
            } else if (matrix[playerRow][playerCol].equals("e")) {
                return true;
            } else {
                matrix[PlayerRow][PlayerCol] = "+";
                PlayerRow = playerRow;
                PlayerCol = playerCol;
            }
        }
        return false;
    }
}
