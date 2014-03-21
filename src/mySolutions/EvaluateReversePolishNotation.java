package mySolutions;

import java.util.LinkedList;

/**
 * Created by Payson Wu on 20/03/14.
 */
public class EvaluateReversePolishNotation {
    public int evalRPN(String[] tokens) {
        LinkedList<String> stack = new LinkedList<String>();
        for (int i = 0; i < tokens.length; i++) {
            if (isOperator(tokens[i])) {
                int curResult = 0;
                int a = Integer.parseInt(stack.pop());
                int b = Integer.parseInt(stack.pop());
                if (tokens[i].equals("+")) {

                    curResult = b + a;
                }
                else if (tokens[i].equals("-")) {
                    curResult = b - a;
                }
                else if (tokens[i].equals("*")) {
                    curResult = b * a;
                }
                else if (tokens[i].equals("/")) {
                    curResult = b / a;
                }
                stack.push("" + curResult);
            } else {
                stack.push(tokens[i]);
            }
        }
        return Integer.parseInt(stack.pop());
    }
    private boolean isOperator(String str) {
        return (str.equals("+") || str.equals("-") || str.equals("*") || str.equals("/"));
    }
}
