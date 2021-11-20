package TextProcessing;

import java.util.Scanner;

public class CaesarCipher {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        String Text = input.nextLine();

        StringBuilder EncryptedText = new StringBuilder();
        for(int i=0;i<=Text.length()-1; i++){
            int tempChar = Text.charAt(i) + 3;
            EncryptedText.append((char)tempChar);
        }

        System.out.println(EncryptedText);
    }
}
