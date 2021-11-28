package TextProcessing;

import java.util.Scanner;

public class ReplaceRepeatingChars {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        StringBuilder newWord = new StringBuilder();
        String Input = input.nextLine();
        String SavedChat = "";
        for(int i=0;i<=Input.length()-1;i++){
            char tempChar = Input.charAt(i);
            if(!SavedChat.equalsIgnoreCase(String.valueOf(tempChar))){
                newWord.append(tempChar);
            }
            SavedChat=String.valueOf(tempChar);
        }
        System.out.println(newWord);
    }
}
