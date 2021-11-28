package JavaOOP.Exercises.Abstraction.jediGalaxy;
import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Matrix matrix = fillMatrix(scanner);
        getSumAndPrint(scanner,matrix);
    }

    private static void getSumAndPrint(Scanner scanner, Matrix matrix) {
        while(true){
            String command = scanner.nextLine();
            if(command.equals("Let the Force be with you")){
                break;
            }
            int[] PlayerIsAt = Arrays.stream(command.split(" ")).mapToInt(Integer::parseInt).toArray();
            int[] EvilIsAt = Arrays.stream(scanner.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();

            matrix.updateEvil(EvilIsAt);
            matrix.updatePlayer(PlayerIsAt);
        }
        System.out.println(matrix.getSum());
    }

    private static Matrix fillMatrix(Scanner scanner) {
        int[] Input = Arrays.stream(scanner.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int rows = Input[0];
        int cols = Input[1];
        return new Matrix(rows,cols);
    }
}