package JavaAdvanced.Examples.StreamsFilesAndDirectories;
import java.io.*;
import java.util.*;

public class MergeTwoFiles {
    public static void main(String[] args) throws FileNotFoundException {
        FileInputStream inputStream1 = new FileInputStream("D:\\JavaAdvanced\\src\\StreamsFilesAndDirectories\\Inputs\\InputOne.txt");
        FileInputStream inputStream2 = new FileInputStream("D:\\JavaAdvanced\\src\\StreamsFilesAndDirectories\\Inputs\\InputTwo.txt");

        Scanner scanner1 = new Scanner(inputStream1);
        Scanner scanner2 = new Scanner(inputStream2);
        PrintStream output = new PrintStream("D:\\JavaAdvanced\\src\\StreamsFilesAndDirectories\\Outputs\\MergeTwoFiles.txt");

        while(scanner1.hasNext()){
            output.println(scanner1.nextLine());
        }

        while (scanner2.hasNext()){
            output.println(scanner2.nextLine());
        }
    }
}
