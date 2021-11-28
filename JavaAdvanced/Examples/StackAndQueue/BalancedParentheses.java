package JavaAdvanced.Examples.StackAndQueue;
import java.util.*;
public class BalancedParentheses {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        String Input = input.nextLine();
        ArrayDeque<Character> ParanthesStack = new ArrayDeque<>();

        for(int i=0;i<Input.length();i++){
            if(!ParanthesStack.isEmpty()) {
                char Check = ParanthesStack.peek();
                if (Check == '{' && Input.charAt(i) == '}') {
                    ParanthesStack.pop();
                    continue;
                }
                if (Check == '(' && Input.charAt(i) == ')') {
                    ParanthesStack.pop();
                    continue;
                }
                if (Check == '[' && Input.charAt(i) == ']') {
                    ParanthesStack.pop();
                    continue;
                }
            }
            ParanthesStack.push(Input.charAt(i));
        }
        System.out.println(ParanthesStack.isEmpty()?"YES":"NO");
    }
}

