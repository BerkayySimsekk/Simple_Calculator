package Model;

import java.util.ArrayList;
import java.util.Stack;


public class Calculator {
    private double result;
    private double firstOperand;
    private double secondOperand;
    private String tempExpression;
    private int index;
    private Stack<Character> operatorStack;
    private Stack<Double> operandStack;
    private ArrayList<String> postfixExpression;

    public Calculator(String expression) {
        tempExpression = "";
        index = 0;
        operatorStack = new Stack<Character>();
        postfixExpression = new ArrayList<String>();

        while(index < expression.length()) {
            if(Character.isDigit(expression.charAt(index)) || expression.charAt(index) == '.') {
                while(index != expression.length() && (Character.isDigit(expression.charAt(index)) || expression.charAt(index) == '.')) {
                    tempExpression += expression.charAt(index);
                    index++;
                }

                postfixExpression.add(tempExpression);
                tempExpression = "";
            }
            else if(expression.charAt(index) == '(') {
                operatorStack.push(expression.charAt(index));
                index++;
            }
            else if(expression.charAt(index) == ')') {
                while(operatorStack.peek() != '(') {
                    postfixExpression.add(String.valueOf(operatorStack.peek()));
                    operatorStack.pop();
                }
                operatorStack.pop();
                index++;
            }
            else {
                while(!operatorStack.isEmpty() && operatorStack.peek() != '(' && precedenceIsGreater(operatorStack.peek(), expression.charAt(index))) {
                    postfixExpression.add(String.valueOf(operatorStack.peek()));
                    operatorStack.pop(); 
                }

                operatorStack.push(expression.charAt(index));
                index++;
            }
        }    

        while(!operatorStack.isEmpty()) {
            postfixExpression.add(String.valueOf(operatorStack.peek()));
            operatorStack.pop();
        }

        operandStack = new Stack<Double>();

        for(int n = 0; n < postfixExpression.size(); n++) {
            if(postfixExpression.get(n).equals("+") || postfixExpression.get(n).equals("-") || postfixExpression.get(n).equals("×") || postfixExpression.get(n).equals("÷")) {
                secondOperand = operandStack.peek();
                operandStack.pop();

                firstOperand = operandStack.peek();
                operandStack.pop();

                if(postfixExpression.get(n).equals("+"))
                    result = firstOperand + secondOperand;
                else if(postfixExpression.get(n).equals("-"))
                    result = firstOperand - secondOperand;
                else if(postfixExpression.get(n).equals("×"))
                    result = firstOperand * secondOperand;
                else
                    result = firstOperand / secondOperand;
                    
                operandStack.push(result);
            }
            else {
                operandStack.push(Double.valueOf(postfixExpression.get(n)));
            }
        }
    }

    private static boolean precedenceIsGreater(char firstOperator, char secondOperator) {
        if((firstOperator == '+' || firstOperator == '-') && (secondOperator == '×' || secondOperator == '÷'))
            return false;
        
        return true;
    }

    public double getResult() {
        return result;
    }
}
