/* Following the specification in the README.md file, provide your 
 * Problem1 class.
 **/
public class Problem1{
public static void main(String[] args){
    
    String test = "0 -"; 
    ExpressionTree b = new ExpressionTree(test); 
    System.out.println(b.eval()); 
    System.out.println(b.infix()); 
    System.out.println(b.postfix()); 
    System.out.println(b.prefix()); 
}
}