package at.fhv.oo;
  
public class StackPostfix  
{ 
    // Method to evaluate value of a postfix expression 
    static int evaluatePostfix(String exp) 
    { 
        //create a stack 
        Stack stack=new Stack(10); 
          
        // Scan all characters one by one 
        for(int i=0;i<exp.length();i++) 
        { 
            char c=exp.charAt(i); 
              
            // If the scanned character is an operand (number here), 
            // push it to the stack. 
            if(Character.isDigit(c)) 
            stack.push(c - '0'); 
              
            //  If the scanned character is an operator, pop two 
            // elements from stack apply the operator 
            else
            { 
                int val1 = stack.pop(); 
                int val2 = stack.pop(); 
                  
                switch(c) 
                { 
                    case '+': 
                    stack.push(val2+val1); 
                    break; 
                      
                    case '-': 
                    stack.push(val2- val1); 
                    break; 
                      
                    case '/': 
                    stack.push(val2/val1); 
                    break; 
                      
                    case '*': 
                    stack.push(val2*val1); 
                    break; 
              } 
            } 
        } 
        return stack.pop();     
    } 
      
    // Driver program to test above functions 
    public static void main(String[] args)  
    { 
        String exp="231*+9-"; 
        System.out.println("postfix evaluation: "+evaluatePostfix(exp)); 
    } 
} 
// Contributed by Sumit Ghosh 