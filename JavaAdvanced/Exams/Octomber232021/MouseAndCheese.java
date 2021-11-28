package JavaAdvanced.Exams.Octomber232021;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class MouseAndCheese {
    public static int PlayerRow = 0;
    public static int PlayerCol = 0;
    public static int CheeseEaten = 0;
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int Size = Integer.parseInt(scanner.nextLine());
        String[][]Matrix = new String[Size][Size];

        for(int row=0;row<Matrix.length;row++){
            List<String> Input = Arrays.stream(scanner.nextLine().split("")).collect(Collectors.toList());
            for(int col=0;col<Matrix[row].length;col++){
                Matrix[row][col]=Input.get(col);
                if(Input.get(col).equals("M")){
                    PlayerRow=row;
                    PlayerCol=col;
                }
            }
        }
        boolean isFinished = false;
        while(true){
            String Input = scanner.nextLine();
            if(Input.equals("end")){
                break;
            }

            switch (Input){
                case"up":
                    isFinished = Move("up",PlayerRow-1,PlayerCol,Matrix);
                    break;
                case"down":
                    isFinished = Move("down",PlayerRow+1,PlayerCol,Matrix);
                    break;
                case"right":
                    isFinished = Move("right",PlayerRow,PlayerCol+1,Matrix);
                    break;
                case"left":
                    isFinished= Move("left",PlayerRow,PlayerCol-1,Matrix);
                    break;
            }

            if(isFinished){
                System.out.println("Where is the mouse?");
                break;
            }
        }

        if(CheeseEaten<5){
            System.out.printf("The mouse couldn't eat the cheeses, she needed %s cheeses more.\n",5-CheeseEaten);
        }else{
            System.out.printf("Great job, the mouse is fed %s cheeses!\n",CheeseEaten);
        }

        for(int row=0;row<Matrix.length;row++){
            for(int col=0;col<Matrix[row].length;col++){
                System.out.printf("%s",Matrix[row][col]);
            }
            System.out.println();
        }
    }

    private static boolean Move(String move,int playerRow, int playerCol, String[][] matrix) {
        if(playerRow<0 || playerRow==matrix.length || playerCol<0 || playerCol==matrix[playerRow].length){
            matrix[PlayerRow][PlayerCol]="-";
            return true;
        }else{
            matrix[PlayerRow][PlayerCol]="-";
            if(matrix[playerRow][playerCol].equals("B")){
                matrix[playerRow][playerCol]="-";
                switch (move){
                    case"up":
                        playerRow--;
                        break;
                    case"down":
                        playerRow++;
                        break;
                    case"left":
                        playerCol--;
                        break;
                    case"right":
                        playerCol++;
                        break;
                }
            }

            if(matrix[playerRow][playerCol].equals("c")){
                CheeseEaten++;
            }

            PlayerRow=playerRow;
            PlayerCol=playerCol;
            matrix[PlayerRow][PlayerCol]="M";

        }
        return false;
    }
}
