package JavaAdvanced.Examples.MultidimensionalArrays;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.stream.Collectors;

public class CrossFire {
    public static void main(String[] args) throws IOException {
        BufferedReader scanner = new BufferedReader(new InputStreamReader(System.in));

        List<List<Integer>> Matrix = FillTheMatrix(scanner);

        while(true){
            String Input = scanner.readLine();
            if(Input.equals("Nuke it from orbit")) {
                break;
            }
            List<Integer>Split = Arrays.stream(Input.split(" ")).map(Integer::parseInt).collect(Collectors.toList());
            int Row = Split.get(0);
            int Col = Split.get(1);
            int Range = Split.get(2);
                getMatrix(Matrix, Row, Col, Range);
        }

        Matrix.forEach(a->{
            for(int i=0;i<a.size();i++){
                System.out.printf("%s ",a.get(i));
            }
            System.out.println();
        });
    }

    private static boolean Validation(int row, int col, List<List<Integer>> matrix) {
        boolean isValid = false;

        if(row>=0 && col>=0 && row<matrix.size() && col<matrix.get(row).size()){
            isValid=true;
        }

        return isValid;
    }

    private static List <List<Integer>> getMatrix(List<List<Integer>> Matrix, int Row, int Col, int Range) {

        for(int i=Row-Range; i<=Row+Range; i++){
            if(Validation(i,Col,Matrix) && i!=Row) {
                Matrix.get(i).remove(Col);
            }
        }
        for(int i=Col+Range;i>=Col-Range;i--){
            if(Validation(Row,i,Matrix)){
                Matrix.get(Row).remove(i);
            }
        }
        Matrix.removeIf(List::isEmpty);
        return Matrix;
    }

    private static List<List<Integer>> FillTheMatrix(BufferedReader scanner) throws IOException {
        List<List<Integer>> Matrix = new ArrayList<>();
        List<Integer> Split = Arrays.stream(scanner.readLine().split(" ")).map(Integer::parseInt).collect(Collectors.toList());
        int Rows = Split.get(0);
        int Cols = Split.get(1);

        int n = 1;
        for (int i = 0; i < Rows; i++) {
            Matrix.add(new ArrayList<>());
            for (int a = 1; a <= Cols; a++) {
                Matrix.get(i).add(n);
                n++;
            }
        }
        return Matrix;
    }
}
