package StreamsFilesAndDirectories;

import java.io.*;
import java.util.*;

public class AllCapitals {
    public static void main(String[] args) throws FileNotFoundException {
        FileInputStream inputStream = new FileInputStream("D:\\JavaAdvanced\\src\\StreamsFilesAndDirectories\\Inputs\\input.txt");
        PrintStream printStream = new PrintStream("D:\\JavaAdvanced\\src\\StreamsFilesAndDirectories\\Outputs\\AllCapitals.txt");
        Scanner scanner = new Scanner(inputStream);

        while(scanner.hasNext()){
            printStream.println(scanner.nextLine().toUpperCase());
        }
    }
}
