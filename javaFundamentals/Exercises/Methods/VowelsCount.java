package Method;

import java.util.*;

public class VowelsCount {
    public static void main(String[] args) {
    Scanner in = new Scanner(System.in);
    String NewText = in.nextLine();
    List<Character> chars = new ArrayList<>(Arrays.asList('a','e','i','o','u','A','E','I','O','U','Y','y'));
    GetSum(NewText, chars);
}

    public static void GetSum(String newText, List<Character> chars) {
        int sum=0;
        for(int i = 0; i<= newText.length()-1; i++) {
            if (chars.contains(newText.charAt(i))) {
                sum += 1;
            }
        }
        System.out.println(sum);
    }
}
