package StreamsFilesAndDirectories;

import java.io.*;
import java.nio.file.DirectoryStream;
import java.util.*;

public class GetFolderSize {
    public static void main(String[] args) throws IOException {
        File folder = new File("D:\\JavaAdvanced\\src\\StreamsFilesAndDirectories\\Exercises Resources");
        long sum = 0;
        for (File file : folder.listFiles()){
            sum += file.length();
        }
        System.out.println("Folder size: " + sum);
    }
}
