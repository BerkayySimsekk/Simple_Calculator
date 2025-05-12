# Simple Calculator 

A personal project to practice the knowledge I gained from CS 102 using JavaFX. This calculator can perform addition, subtraction, multiplication and division. Parentheses can be used to separate the expressions. The input from the user is taken as infix expression which is turned into postfix expression to evaluate the result by using a stack object.

## How to Run the Program

A detailed guide can be found to use JavaFX in the following link: https://openjfx.io/openjfx-docs/#install-javafx

## Description

- "AC" means all clear which clears the screen.
- "CE" means clear entry which clears the latest entry.
- The equals button cannot be used unless there is a matching right parenthesis for every left parenthesis.
- Multiplication and division are performed first, working from left to right, before doing addition and subtraction.
- The expression in the innermost parentheses is evaluated first.
- Not using any operation signs before and after parentheses is not allowed; for instance, "5(5+7)" cannot be used while "5x(5+7)" can be used.

