package StackAndQueue;
import java.util.*;
import java.util.stream.Collectors;

public class MaximumElement {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int N = Integer.parseInt(input.nextLine());

        ArrayDeque<Integer>Secuence = new ArrayDeque<>();

        while(N-->0){
            List<String>Split = Arrays.stream(input.nextLine().split(" ")).collect(Collectors.toList());
            String Command = Split.get(0);
            switch(Command){
                case"1":
                    int Value = Integer.parseInt(Split.get(1));
                    Secuence.push(Value);
                    break;
                case"2":
                    Secuence.pop();
                    break;
                case"3":
                    int Maximum = Secuence.stream()
                            .mapToInt(Integer::valueOf)
                            .max()
                            .getAsInt();
                    System.out.println(Maximum);
                    break;
            }
        }
    }
}
