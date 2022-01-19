package JavaOOP.Exercises.Abstraction.jediGalaxy;

public class Matrix {
    private int[][] matrix;
    private long sum;

    public Matrix(int Rows, int Cols){
        matrix=new int [Rows][Cols];
        int Count = 0;
        for (int row = 0; row < Rows; row++)
        {
            for (int col = 0; col < Cols; col++)
            {
                matrix[row][col] = Count++;
            }
        }
    }

    public long getSum() {
        return sum;
    }

    public void updatePlayer(int[] playerIsAt) {
        int playerRow = playerIsAt[0];
        int playerCol = playerIsAt[1];

        while (playerRow >= 0 && playerCol < matrix[1].length)
        {
            if (playerRow >= 0 && playerRow < matrix.length && playerCol >= 0 && playerCol < matrix[0].length)
            {
                sum += matrix[playerRow][playerCol];
            }

            playerCol++;
            playerRow--;
        }
    }

    public void updateEvil(int[] evilIsAt) {
        int evilRow = evilIsAt[0];
        int evilCol = evilIsAt[1];

        while (evilRow >= 0 && evilCol >= 0)
        {
            if (evilRow >= 0 && evilRow < matrix.length && evilCol >= 0 && evilCol < matrix[0].length)
            {
                matrix[evilRow] [evilCol] = 0;
            }
            evilRow--;
            evilCol--;
        }
    }
}
