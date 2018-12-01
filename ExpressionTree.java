/* Alex Brice Horimbere
 * abh2167
 * Expression Tree with eval methods
 * postfix and prefix and infix
 **/



import java.util.LinkedList; 
import java.util.ArrayList; 
import java.lang.*; 
import java.util.*; 


public class ExpressionTree {
    
    ExpressionNode root; 
    MyStack<ExpressionNode> stack;
    
        public ExpressionTree(String expression) {
            
            stack = new MyStack<>();
            root = null;  
            
            
            String[] op = expression.split("\\s+"); //split the string
            for(int i = 0; i < op.length; i++){
                
                ExpressionNode leftNode = null; 
                ExpressionNode rightNode = null; 
                
                if(!op[i].equals("+") && !op[i].equals("-") && !op[i].equals("*")
                  && !op[i].equals("/")){
                    
                    //leaf node --Operand 
                    stack.push(new ExpressionNode (op[i], null, null)); 
                }
                else{//Parent Node --Operator
                    
                    if(stack.isEmpty()){
                        //underflow
                        
                        System.out.println("Invalid Tree! Try again with a valid expression"); 
                        System.exit(0); 
                    }
                    else{
                        rightNode = stack.pop(); 
                        if(stack.isEmpty()){
                            //undeflow
                            
                            System.out.println("Invalid Tree! Try again with a valid expression"); 
                            System.exit(0);
                        }
                        else{
                            leftNode = stack.pop(); 
                        }
                        stack.push(new ExpressionNode(op[i], leftNode, rightNode)); 
                    }
                    
                }
                
                root = stack.peek(); 
                System.out.println(root.data); 
              }
            stack.pop(); 
            
            if(stack.size() != 0){
                System.out.println("Invalid Expression!"); 
                System.exit(0); 
            }
        }
    
    
         
         public int eval(){
             //public eval(). Calls private eval()
             
             if(root == null){
                 System.out.println("This shouldn't happen!"); 
                 System.exit(0); 
             }
                 return eval(root);
             
              
         }
    
        public String postfix() {
            
            //public postfix(). Calls private method
            if(root == null){
                System.out.println("Why is the root null?"); 
                System.exit(0); 
            }
            return postfix(root); 
            
        }
    
    
        public String prefix() {
            
              /* calls private prefix() */
            if(root == null){
                System.out.println("Why is the root null?"); 
                System.exit(0); 
            }
            return prefix(root); 
            
        }

        public String infix() {
            //calls private infix()
            if(root == null){
                System.out.println("Why is the root null?"); 
                System.exit(0); 
            }
            return infix(root); 
            
        }
    
        
        private int eval(ExpressionNode tmp){
            
            if(tmp.left == null && tmp.right == null){
               
                //leaf nodes
                //must be operands
                int a = Integer.parseInt(tmp.data); 
                return a;  
                
            }
            
            //parent nodes. call eval() recursively.
                int a = eval(tmp.left); 
                int b = eval(tmp.right); 
                
            //evaluate node according to the operator
                if(tmp.data.equals("+")){
                    return a + b; 
                }
                else if(tmp.data.equals("-")){
                    return a - b; 
                }
                else if(tmp.data.equals("*")){
                    return a * b; 
                }
            return a / b; 
            
        }
    
        private String postfix(ExpressionNode tmp){
            //Left, Right, Node
            
           if(tmp.left == null && tmp.right == null){
               //leaf nodes
               return tmp.data; 
           }
            
            String post = " "; 
            post = postfix(tmp.left); 
            post = post.concat(postfix(tmp.right)); 
            post = post.concat(tmp.data); 
            
            return post; 
                
        }
    
       private String prefix(ExpressionNode tmp){
           //Node, left, right
           
           if(tmp.left == null && tmp.right == null){
               return tmp.data; 
           }
           
           String pre = " "; 
           pre = tmp.data; 
           pre = pre.concat(prefix(tmp.left)); 
           pre = pre.concat(prefix(tmp.right)); 
           
           return pre; 
       }
    
      private String infix(ExpressionNode tmp){
          //Left, node, right
          
          if(tmp.left == null && tmp.right == null){
              return tmp.data; 
          }
          
          String in = "("; 
          in = in.concat(infix(tmp.left)); 
          in = in.concat(")"); 
          in = in.concat(tmp.data); 
          in = in.concat("("); 
          in = in.concat(infix(tmp.right)); 
          in = in.concat(")"); 
          
          return in; 
      }
    
    
         /* You will need to provide the private, recursive versions of these methods, 
          * the instance variable(s), and any static nested class that you might need below */
    
      
    
       
    
       
    
    private static class ExpressionNode { //Expression Node class. 
        
        String data; 
        ExpressionNode left; 
        ExpressionNode right; 
        
        public ExpressionNode(String data, ExpressionNode left, ExpressionNode right){
            this.data = data; 
            this.left = left; 
            this.right = right; 
        }
    }
  }
     
