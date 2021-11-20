package StreamsFilesAndDirectories;

import java.io.*;
import java.util.*;

public class SumBytes {
    public static void main(String[] args) throws IOException {
        FileInputStream inputStream = new FileInputStream("D:\\JavaAdvanced\\src\\StreamsFilesAndDirectories\\Inputs\\input.txt");
        Scanner Input = new Scanner(inputStream);
        int total = 0;
        while(Input.hasNext()){
            char [] LineToChar = Input.nextLine().toCharArray();
            int sum=0;
            for (char c : LineToChar) {
                int ASCIchar = c;
                sum+=ASCIchar;
            }
            total+=sum;
        }

        System.out.println(total);
    }
}
