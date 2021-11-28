package Exams.August182021;

import java.util.*;
import java.util.stream.Collectors;

public class FormulaOne {
    public static int PlayerRow = 0;
    public static int PlayerCol = 0;
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int Size = Integer.parseInt(scanner.nextLine());
        int CountOfCommands = Integer.parseInt(scanner.nextLine());
        String[][]Matrix = new String[Size][Size];

        for(int row=0;row<Matrix.length;row++){
            List<String>Input = Arrays.stream(scanner.nextLine().split("")).collect(Collectors.toList());
            for(int col=0;col<Matrix[row].length;col++){
                Matrix[row][col]=Input.get(col);
                if(Input.get(col).equals("P")){
                    PlayerRow=row;
                    PlayerCol=col;
                }
            }
        }
        boolean isFinished = false;
        while (CountOfCommands-->0){
            String Command = scanner.nextLine();
            switch (Command){
                case"up":
                    isFinished = Move("up",PlayerRow-1,PlayerCol,Matrix.length-1,PlayerCol,Matrix);
                    break;
                case"down":
                    isFinished = Move("down",PlayerRow+1,PlayerCol,0,PlayerCol,Matrix);
                    break;
                case"left":
                    isFinished = Move("left",PlayerRow,PlayerCol-1,PlayerRow,Matrix.length-1,Matrix);
                    break;
                case"right":
                    isFinished = Move("right",PlayerRow,PlayerCol+1,PlayerRow,0,Matrix);
                    break;
            }
            if(isFinished){
                System.out.println("Well done, the player won first place!");
                break;
            }
        }

        if(!isFinished){
            System.out.println("Oh no, the player got lost on the track!");
        }

        for(int row=0;row<Matrix.length;row++){
            for(int col=0;col<Matrix[row].length;col++){
                System.out.printf("%s",Matrix[row][col]);
            }
            System.out.println();
        }
    }

    private static boolean Move(String Case,int playerRow, int playerCol, int OutsidePlayerRow, int OutsidePlayerCol, String[][] matrix) {
        if(playerRow<0 || playerRow==matrix.length || playerCol<0 || playerCol==matrix[playerRow].length){
            playerRow=OutsidePlayerRow;
            playerCol=OutsidePlayerCol;
        }

        if(matrix[playerRow][playerCol].equals("B")){
            switch (Case){
                case"up":
                    playerRow--;
                    if(playerRow<0){
                        playerRow=matrix.length-1;
                    }
                    break;
                case"down":
                    playerRow++;
                    if(playerRow==matrix.length){
                        playerRow=0;
                    }
                    break;
                case"left":
                    playerCol--;
                    if(playerCol<0){
                        playerCol=matrix.length-1;
                    }
                    break;
                case"right":
                    playerCol++;
                    if(playerCol==matrix.length){
                        playerCol=0;
                    }
                    break;
            }
            matrix[PlayerRow][PlayerCol]=".";
            PlayerRow=playerRow;
            PlayerCol=playerCol;
            matrix[PlayerRow][PlayerCol]="P";
        }else if(matrix[playerRow][playerCol].equals("T")) {
            switch (Case){
                case"up":
                    playerRow++;
                    if(playerRow==matrix.length){
                        playerRow=0;
                    }
                    break;
                case"down":
                    playerRow--;
                    if(playerRow<0){
                        playerRow=matrix.length-1;
                    }
                    break;
                case"left":
                    playerCol++;
                    if(playerCol==matrix.length){
                        playerCol=0;
                    }
                    break;
                case"right":
                    playerCol--;
                    if(playerCol<0){
                        playerCol=matrix.length-1;
                    }
                    break;
            }
            matrix[PlayerRow][PlayerCol]=".";
            PlayerRow=playerRow;
            PlayerCol=playerCol;
            matrix[PlayerRow][PlayerCol]="P";
        }else if(matrix[playerRow][playerCol].equals("F")){
            matrix[PlayerRow][PlayerCol]=".";
            PlayerRow=playerRow;
            PlayerCol=playerCol;
            matrix[PlayerRow][PlayerCol]="P";
            return true;
        }else{
            matrix[PlayerRow][PlayerCol]=".";
            PlayerRow=playerRow;
            PlayerCol=playerCol;
            matrix[PlayerRow][PlayerCol]="P";
        }
        return false;
    }
}
