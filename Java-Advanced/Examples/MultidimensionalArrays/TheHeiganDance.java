package MultidimensionalArrays;
import java.util.Scanner;

public class TheHeiganDance {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        double BossPoints = 3000000.0;
        int PlayerPoints = 18500;

        int StartPlayerRow = 7;
        int StartPlayerCol = 7;

        String LastSpell = "";
        boolean activeCloud = false;

        double damage = Double.parseDouble(scanner.nextLine());

        while (PlayerPoints > 0 && BossPoints > 0) {
            BossPoints -= damage;

            if (activeCloud) {
                PlayerPoints -= 3500;
                activeCloud = false;

                if (PlayerPoints < 0) {
                    break;
                }
            }

            if (BossPoints < 0) {
                break;
            }

            String[] tokens = scanner.nextLine().split("\\s+");

            String spell = tokens[0];
            int row = Integer.parseInt(tokens[1]);
            int col = Integer.parseInt(tokens[2]);

            boolean[][] hsChamber = new boolean[15][15];
            for (int i = row - 1; i <= row + 1; i++) {
                if (i >= 0 && i < hsChamber.length) {
                    for (int j = col - 1; j <= col + 1; j++) {
                        if (j >= 0 && j < hsChamber[row].length) {
                            hsChamber[i][j] = true;
                        }
                    }
                }
            }

            if (hsChamber[StartPlayerRow][StartPlayerCol]) {
                if (isRowValid(hsChamber, StartPlayerRow - 1) && !hsChamber[StartPlayerRow - 1][StartPlayerCol]) {
                    StartPlayerRow--; // move up
                } else if (isColValid(hsChamber, StartPlayerCol + 1) && !hsChamber[StartPlayerRow][StartPlayerCol + 1]) {
                    StartPlayerCol++; // move right
                } else if (isRowValid(hsChamber, StartPlayerRow + 1) && !hsChamber[StartPlayerRow + 1][StartPlayerCol]) {
                    StartPlayerRow++; // move down
                } else if (isColValid(hsChamber, StartPlayerCol - 1) && !hsChamber[StartPlayerRow][StartPlayerCol - 1]) {
                    StartPlayerCol--; // move left
                }

                if (hsChamber[StartPlayerRow][StartPlayerCol]) {
                    switch (spell) {
                        case "Cloud":
                            PlayerPoints -= 3500;
                            activeCloud = true;
                            LastSpell = "Plague Cloud";
                            break;
                        case "Eruption":
                            PlayerPoints -= 6000;
                            LastSpell = spell;
                            break;
                        default:
                            throw new IllegalArgumentException("Invalid spell: " + spell);
                    }
                }
            }
        }

        if (BossPoints > 0) {
            System.out.printf("Heigan: %.2f%n", BossPoints);
        } else {
            System.out.println("Heigan: Defeated!");
        }
        if (PlayerPoints > 0) {
            System.out.printf("Player: %d%n", PlayerPoints);
        } else {
            System.out.println("Player: Killed by " + LastSpell);
        }

        System.out.println("Final position: " + StartPlayerRow + ", " + StartPlayerCol);
    }

    private static boolean isRowValid(boolean[][] hsChamber, int startPlRow) {
        return startPlRow >= 0 && startPlRow < hsChamber[startPlRow].length;
    }

    private static boolean isColValid(boolean[][] hsChamber, int startPlCol) {
        return startPlCol >= 0 && startPlCol < hsChamber.length;
    }
}