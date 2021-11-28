package JavaAdvanced.Exams.December162020;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Selling {
    public static int PlayerRow = 0;
    public static int PlayerCol = 0;
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int Size = Integer.parseInt(scanner.nextLine());
        String[][]Matrix = new String[Size][Size];

        for(int row=0;row<Matrix.length;row++){
            List<String>Input = Arrays.stream(scanner.nextLine().split("")).collect(Collectors.toList());
            for(int col=0;col<Matrix.length;col++){
                Matrix[row][col]=Input.get(col);
                if(Matrix[row][col].equals("S")){
                    PlayerRow=row;
                    PlayerCol=col;
                }
            }
        }
    }
}
