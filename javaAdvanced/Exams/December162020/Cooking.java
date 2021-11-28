package Exams.December162020;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Cooking {
    public static int PlayerRow = 0;
    public static int PlayerCol =0;
    public static int Pilar1row = 0;
    public static int Pilar1col = 0;
    public static int Pilar2col =0;
    public static int Pilar2row = 0;
    public static int Deposit = 0;
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int Size = Integer.parseInt(scanner.nextLine());
        String[][] Matrix = new String[Size][Size];
        int Count = 0;
        for (int row = 0; row < Size; row++) {
            List<String> Input = Arrays.stream(scanner.nextLine().split("")).collect(Collectors.toList());
            for (int col = 0; col < Size; col++) {
                Matrix[row][col] = Input.get(col);
                if(Matrix[row][col].equals("S")){
                    PlayerRow = row;
                    PlayerCol = col;
                }
                if(Matrix[row][col].equals("O") && Count==0){
                    Pilar1col = col;
                    Pilar1row= row;
                    Count++;
                }

                if(Matrix[row][col].equals("O") && Count==1){
                    Pilar2row=row;
                    Pilar2col=col;
                }
            }
        }

        boolean isOut = false;

        while(Deposit<50){
            String Command = scanner.nextLine();
            switch (Command){
                case "up":
                    isOut = Move(PlayerRow-1,PlayerCol,Matrix);
                    break;
                case"down":
                    isOut=Move(PlayerRow+1,PlayerCol,Matrix);
                    break;
                case"left":
                    isOut=Move(PlayerRow,PlayerCol-1,Matrix);
                    break;
                case"right":
                    isOut=Move(PlayerRow,PlayerCol+1,Matrix);
                    break;
            }
            if(isOut){
                System.out.println("Bad news, you are out of the bakery.");
                break;
            }
        }

        if(Deposit>=50){
            System.out.println("Good news! You succeeded in collecting enough money!");
        }

        System.out.printf("Money: %s\n",Deposit);
        for(int row=0;row<Matrix.length;row++){
            for(int col=0;col<Matrix[row].length;col++){
                System.out.printf("%s",Matrix[row][col]);
            }
            System.out.println();
        }

    }
    private static boolean Move(int playerRow, int playerCol, String[][] matrix) {
        if(playerRow==matrix.length || playerRow<0 || playerCol==matrix[playerRow].length || playerCol<0){
            matrix[PlayerRow][PlayerCol]="-";
            return true;
        }else{
            if(Character.isDigit(matrix[playerRow][playerCol].charAt(0))){
                matrix[PlayerRow][PlayerCol]="-";
                Deposit+=Integer.parseInt(matrix[playerRow][playerCol]);
                PlayerRow=playerRow;
                PlayerCol=playerCol;
                matrix[PlayerRow][PlayerCol]="S";
            }else if(matrix[playerRow][playerCol].equals("O")){
                if (playerRow == Pilar1row && playerCol==Pilar1col){
                    matrix[PlayerRow][PlayerCol]="-";
                    matrix[playerRow][playerCol]="-";
                    PlayerRow=Pilar2row;
                    PlayerCol=Pilar2col;
                    matrix[PlayerRow][PlayerCol]="S";
                }else if(playerRow == Pilar2row && playerCol == Pilar2col){
                    matrix[PlayerRow][PlayerCol]="-";
                    matrix[playerRow][playerCol]="-";
                    PlayerRow=Pilar1row;
                    PlayerCol=Pilar1col;
                    matrix[PlayerRow][PlayerCol]="S";
                }
            }else{
                matrix[PlayerRow][PlayerCol]="-";
                PlayerRow=playerRow;
                PlayerCol=playerCol;
                matrix[PlayerRow][PlayerCol]="S";
            }
        }
        return false;
    }
}
