package neetcode.stack;

import java.util.ArrayDeque;
import java.util.Deque;

public class EvaluateReversePolishNotation {
    public int evalRPN(String[] tokens) {
        Deque<Integer> stack = new ArrayDeque<>();

        for (String s : tokens) {
            if (s.equals("+") || s.equals("-") || s.equals("*") || s.equals("/")) {
                int a = stack.pop();
                int b = stack.pop();
                int currentResult = switch (s) {
                    case "+" -> a + b;
                    case "-" -> b - a;
                    case "*" -> a * b;
                    case "/" -> b / a;
                    default -> 0;
                };

                stack.push(currentResult);
            } else {
                stack.push(Integer.parseInt(s));
            }
        }

        return stack.pop();
    }
}
