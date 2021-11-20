package TextProcessing;

import java.util.*;

public class StringExplosion {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        String Input = input.nextLine();
        StringBuilder Line = new StringBuilder();
        int Bomb = 0;

        for (int i = 0; i <= Input.length() - 1; i++) {
            String Char = String.valueOf(Input.charAt(i));
            if (Char.equalsIgnoreCase(">")) {
                {
                    Bomb += Integer.parseInt(String.valueOf(Input.charAt(i + 1)));
                    Line.append(Char);
                }
            } else if (Bomb > 0 && !Char.equalsIgnoreCase(">")) {
                Bomb--;
            } else {
                Line.append(Char);
            }
        }

        System.out.println(Line);
    }
}