package TextProcessing;

import java.util.*;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class ExtractFile {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        List<String>TextPath = Arrays.stream(input.nextLine().split(Pattern.quote("\\"))).collect(Collectors.toList());;

        List<String>LastSplit = Arrays.stream(TextPath.get(TextPath.size()-1).split(Pattern.quote("."))).collect(Collectors.toList());

        System.out.printf("File name: %s\nFile extension: %s",LastSplit.get(0),LastSplit.get(1));
    }
}