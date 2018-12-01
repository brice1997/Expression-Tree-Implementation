# Expression-Tree-Implementation

This program implements an expression tree using a binary tree. We recall that an expression tree is a binary tree in which iternal nodes correspond to an operator while the leaf ndoes correspond to an operand. The operands are integers and the binary operators are restricted to +, -, *, and /. An example of a postfix expression is: 

34 2 - 5 *

The corresponding infix expression is (34-2)*5.

The constructor uses a stack to build the expression Tree. 

Description of the algorithm: 
1. The stack is made of Expression Tree nodes. 
2. While parsing through the postfix expression: if it is an operand, create a new node containing the integer value, then push it onto the stack. Else pop the last two nodes from the stack. 
3. Repeat 2 until the stack is empty. 
4. It goes without saying that if the stack is not empty, or is underflown before the end of the expression, the postfix expression is not valid. push an operand (an integer) ExpressionNode will be a nested class within ExpressionTree. You momis assignment. Fuse java.util.LinkedList, your own class from Homework 2, or the MyStack.java file fromaded). Please indicate your choice in the STUDENTREADME.md file.

The following functions are provided: 

public int eval() - this method, when invoked on an expression tree object, will return the integer value associated with evaluating the expression tree. It will need to call a private recursive method that takes in the root.

public String postfix() - this method, when invoked on an expression tree object, will return a String that contains the corresponding postfix expression. It will need to call a private recursive method that takes in the root.

public String prefix() - this method, when invoked on an expression tree object, will return a String that contains the corresponding prefix expression. It will need to call a private recursive method that takes in the root.

public String infix() - this method, when invoked on an expression tree object, will return a String that contains the corresponding correct infix expression. Keep in mind that parenthesrs will be needed (excessive parenthesis will be tolerated as long as they are correctly placed). It will need to call a private recursive method that takes in the root.

public ExpressionTree(String expression) - this is the constructor of the expression tree. It will take in a String that stores a postfix expression (as indicated above). Build the expression tree from that postfix expression using the stack based algorithm here.


Problem1.java (specifically, its main method) tests the above functions. 
