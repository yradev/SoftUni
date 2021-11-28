package JavaAdvanced.Examples.StackAndQueue;
import java.util.*;
import java.util.stream.Collectors;

public class ReverseNumbersWithAStack {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        List<String>text = Arrays.stream(input.nextLine().split(" ")).collect(Collectors.toList());

        ArrayDeque<Integer>Numbers = new ArrayDeque<>();
        for (String s : text) {
            Numbers.push(Integer.parseInt(s));
        }

        while(!Numbers.isEmpty()){
            System.out.printf("%s ",Numbers.poll());
        }
    }
}
