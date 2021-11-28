package JavaAdvanced.Examples.StreamsFilesAndDirectories;

import java.io.*;
import java.util.*;

public class SumLines {
    public static void main(String[] args) throws IOException {
        FileInputStream inputStream = new FileInputStream("D:\\JavaAdvanced\\src\\StreamsFilesAndDirectories\\Inputs\\input.txt");
        Scanner Input = new Scanner(inputStream);
        while(Input.hasNext()){
            char [] LineToChar = Input.nextLine().toCharArray();
            int sum=0;
            for (char c : LineToChar) {
                int ASCIchar = c;
                sum+=ASCIchar;
            }
            System.out.println(sum);
        }
    }
}
