package MultidimensionalArrays;
import java.util.*;
import java.util.stream.Collectors;

public class StringMatrixRotation {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<String> RotationScanner = Arrays.stream(scanner.nextLine().split("([^\\d])")).collect(Collectors.toList());
        RotationScanner = RotationScanner.stream().filter(c -> !c.isEmpty()).map(String::valueOf).collect(Collectors.toList());
        int RotationInput = Integer.parseInt(String.join("", RotationScanner));
        List<String> Arrays = new ArrayList<>();
        while (true) {
            String Input = scanner.nextLine();
            if (Input.equals("END")) {
                break;
            } else {
                Arrays.add(Input);
            }
        }
        String[][] Matrix = new String[Arrays.size()][];
        int Rotation = RotationInput;
        while (Rotation>360) {
            Rotation-=360;
        }

        if (Rotation == 90) {
            Matrix = getRotation90(Arrays);
        } else if (Rotation == 180) {
            Matrix = getRotation180(Arrays);
        } else if (Rotation == 270) {
            Matrix = getRotation270(Arrays);
        } else if (Rotation == 0 || Rotation == 360){
            Matrix = getRotation360(Arrays);
        }

        for (int i = 0; i < Matrix.length; i++) {
            for (int a = 0; a < Matrix[i].length; a++) {
                if (Matrix[i][a] != null) {
                    System.out.printf("%s", Matrix[i][a]);
                } else {
                    System.out.print(" ");
                }
            }
            System.out.println();
        }
    }

    private static String[][] getRotation360(List<String> Arrays) {
        int Cols = Arrays.stream()
                .mapToInt(String::length)
                .max()
                .getAsInt();

        String[][] matrix = new String[Arrays.size()][Cols];
        for (int i = 0; i < matrix.length; i++) {
            for (int a = 0; a < Arrays.get(i).length(); a++) {
                matrix[i][a] = String.valueOf(Arrays.get(i).charAt(a));
            }
        }
        return matrix;
    }

    private static String[][] getRotation270(List<String> Arrays) {
        int Rows = Arrays.stream()
                .mapToInt(String::length)
                .max()
                .getAsInt();

        String[][] matrix = new String[Rows][Arrays.size()];
        int Index = 0;
        int IndexRow = matrix.length - 1;
        for (int i = 0; i < Arrays.size(); i++) {
            for (int a = 0; a < Arrays.get(i).length(); a++) {
                matrix[IndexRow][Index] = String.valueOf(Arrays.get(i).charAt(a));
                IndexRow--;
            }
            IndexRow = matrix.length - 1;
            Index++;
        }
        return matrix;
    }

    private static String[][] getRotation180(List<String> Arrays) {
        int Cols = Arrays.stream()
                .mapToInt(String::length)
                .max()
                .getAsInt();

        String[][] matrix = new String[Arrays.size()][Cols];
        int Index = matrix[0].length - 1;
        int IndexRow = 0;
        for (int i = Arrays.size() - 1; i >= 0; i--) {
            for (int a = 0; a < Arrays.get(i).length(); a++) {
                matrix[IndexRow][Index] = String.valueOf(Arrays.get(i).charAt(a));
                Index--;
            }
            Index = matrix[0].length - 1;
            IndexRow++;
        }
        return matrix;
    }

    private static String[][] getRotation90(List<String> Arrays) {
        int Rows = Arrays.stream()
                .mapToInt(String::length)
                .max()
                .getAsInt();

        String[][] matrix = new String[Rows][Arrays.size()];
        int Index = 0;
        for (int i = Arrays.size() - 1; i >= 0; i--) {
            for (int a = 0; a < Arrays.get(i).length(); a++) {
                matrix[a][Index] = String.valueOf(Arrays.get(i).charAt(a));
            }
            Index++;
        }
        return matrix;
    }
}
