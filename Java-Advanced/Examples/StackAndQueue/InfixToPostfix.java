package StackAndQueue;

import java.util.*;
import java.util.stream.Collectors;

public class InfixToPostfix {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        List<String> Input = Arrays.stream(input.nextLine().split(" ")).collect(Collectors.toList());
        String Symbols = "+-/*()";
        List<String>OutPut = new ArrayList<>();
        ArrayDeque<String> Operators = new ArrayDeque<>();

        for (int i = 0; i < Input.size(); i++) {
            String currentChar = Input.get(i);
            if (Character.isLetter(currentChar.charAt(0)) || Character.isDigit(currentChar.charAt(0))) {
                OutPut.add(currentChar);
            } else if (Symbols.contains(currentChar)) {
                if (Operators.isEmpty()) {
                    Operators.push(currentChar);
                } else {
                    String LastOperator = Operators.peek();
                    if (currentChar.equals("+") || currentChar.equals("-")) {
                        if (LastOperator.equals("(")) {
                            Operators.push(currentChar);
                        } else {
                            OutPut.add(Operators.pop());
                            Operators.push(currentChar);
                        }
                    } else if (currentChar.equals("/") || currentChar.equals("*")) {
                        if (LastOperator.equals("*") || LastOperator.equals("/")) {
                            OutPut.add(Operators.pop());
                            Operators.push(currentChar);
                        } else {
                            Operators.push(currentChar);
                        }
                    } else if (currentChar.equals("(")) {
                        Operators.push(currentChar);
                    } else if (currentChar.equals(")")) {
                        while (!Operators.peek().equals("(")) {
                            OutPut.add(Operators.pop());
                        }
                        Operators.pop();
                    }
                }
            }
        }

        while (!Operators.isEmpty()) {
            OutPut.add(Operators.poll());
        }

        String endString = String.join(" ",OutPut);
        System.out.println(endString);
    }
}