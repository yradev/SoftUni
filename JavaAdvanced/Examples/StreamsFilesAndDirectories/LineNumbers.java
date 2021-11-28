package JavaAdvanced.Examples.StreamsFilesAndDirectories;
import java.io.*;
import java.util.*;
public class LineNumbers {
    public static void main(String[] args) throws FileNotFoundException {
        FileInputStream inputStream = new FileInputStream("D:\\JavaAdvanced\\src\\StreamsFilesAndDirectories\\Inputs\\inputLineNumbers.txt");
        Scanner scanner = new Scanner(inputStream);
        PrintStream output = new PrintStream("D:\\JavaAdvanced\\src\\StreamsFilesAndDirectories\\Outputs\\LineNumbers.txt");
        int Count =1;
        while(scanner.hasNext()){
            output.printf("%s. %s\n",Count,scanner.nextLine());
            Count++;
        }
    }
}
