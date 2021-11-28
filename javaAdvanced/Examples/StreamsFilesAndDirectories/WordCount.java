package StreamsFilesAndDirectories;
import java.io.*;
import java.util.*;
public class WordCount {
    public static void main(String[] args) throws FileNotFoundException {
        Map<String,Integer>Words = new LinkedHashMap<>();
        getWords(Words);
        FileInputStream inputStream = new FileInputStream("D:\\JavaAdvanced\\src\\StreamsFilesAndDirectories\\Inputs\\text.txt");
        PrintStream output = new PrintStream("D:\\JavaAdvanced\\src\\StreamsFilesAndDirectories\\Outputs\\WordCount.txt");
        Scanner scanner = new Scanner(inputStream);
        while(scanner.hasNext()){
            String word = scanner.next();
            if(Words.containsKey(word)){
                int Value=Words.get(word)+1;
                Words.put(word,Value);
            }
        }

        Words.forEach((key, value) -> output.printf("%s - %s\n", key, value));
    }

    private static void getWords(Map<String,Integer> Words) throws FileNotFoundException {
        FileInputStream WordsStream = new FileInputStream("D:\\JavaAdvanced\\src\\StreamsFilesAndDirectories\\Inputs\\words.txt");
        Scanner scanner = new Scanner(WordsStream);

        while(scanner.hasNext()){
            Words.put(scanner.next(),0);
        }
    }
}
