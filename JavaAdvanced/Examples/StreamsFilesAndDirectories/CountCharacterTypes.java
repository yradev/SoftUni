package JavaAdvanced.Examples.StreamsFilesAndDirectories;
import java.io.*;
import java.util.*;
public class CountCharacterTypes {
    public static void main(String[] args) throws FileNotFoundException {
        Set<Character>Vowels = Set.of('a','e','i','o','u');
        Set<Character>Punctuation = Set.of('!',',','.','?');
        FileInputStream inputStream = new FileInputStream("D:\\JavaAdvanced\\src\\StreamsFilesAndDirectories\\Inputs\\input.txt");
        Scanner scanner = new Scanner(inputStream);
        int VowelsCount =0;
        int Consonants = 0;
        int Punctuations = 0;
        while(scanner.hasNext()){
            char [] charsLine = scanner.nextLine().toCharArray();
            for (char c : charsLine) {
                if(c!=32) {
                    if (Vowels.contains(c)) {
                        VowelsCount++;
                    } else if(!Vowels.contains(c) && !Punctuation.contains(c)){
                        Consonants++;
                    }else{
                        Punctuations++;
                    }
                }
            }
        }

        PrintStream output = new PrintStream("D:\\JavaAdvanced\\src\\StreamsFilesAndDirectories\\Outputs\\CountCharacterTypes.txt");

        output.printf("Vowels: %s\nConsonants: %s\nPunctuation: %s",VowelsCount,Consonants,Punctuations);
    }
}
