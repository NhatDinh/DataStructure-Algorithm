package stack;
import java.util.Stack;

/*
[Documentation](https://github.com/NhatDinh/DataStructures-Algorithms/wiki/ArithmeticExpressionEvaluator)
*/

public class ArithmeticExpressionEvaluator {
	// print infix expression
	static void printInfix(String infix) {
		System.out.println(infix);
	}
	
	//print postfix expression
	static void printPostfix(String infix) {
		String postfix = InfixToPostfix(infix);
		System.out.println(postfix);
	}
	
	//print final result
	static void printFinalResult(String infix) {
		String postfix = InfixToPostfix(infix);
		Integer finalResult = EvaluatePostfix(postfix);
		System.out.println(finalResult);
	}
	
	//return precedence of char
	static int Precedence(char c) {
			switch (c)
	        {
	        case '+':
	        case '-':
	            return 1;
	      
	        case '*':
	        case '/':
	            return 2;
	      
	        case '^':
	            return 3;
	        }
	        return -1;
		}
	static String InfixToPostfix(String infix) {
			String postfix = new String();
			
			//Going to be replaced later using my own stack implementation
			// can be either linked list or resizing array stack.
			Stack<Character> stack = new Stack<>();
			
			for (int i = 0; i < infix.length(); i++ ) {
				char cInfix = infix.charAt(i);
				if (Character.isLetterOrDigit(cInfix)) {
					postfix += cInfix;
				}
				else if ( cInfix == '(' ) {
					stack.push(cInfix);
				}
				else if ( cInfix == ')' ) {
					while( !stack.empty() && stack.peek() != '(' ) {
						postfix += stack.pop();
					}
					stack.pop();
					
				}
				//if cInfix  is an operator
				else {
					//Precedence is an in-house built method
					while( !stack.empty() && Precedence(cInfix) <= Precedence(stack.peek())) {
						postfix += stack.pop();
					}
					stack.push(cInfix);
				}
				}
			//at the end of input
			while(!stack.empty()) {
				postfix += stack.pop();
			}
			
			//printStackElements call
			return postfix;
		}
	
	//TODO: solve edge case: multiple value
	static Integer EvaluatePostfix(String postfix) {
		Stack<Integer> stack = new Stack();
		for(int c = 0; c < postfix.length() ; c++) {
			char cPostfix = postfix.charAt(c);
			if( Character.isDigit(cPostfix)) 
				stack.push(cPostfix - '0'); //[Explanation:] (...) 
				                          
			//if cPostfix is an operator
			else {
					int val1 = stack.pop();
					int val2 = stack.pop();
					
					switch (cPostfix) {		
			        case '+':
			        stack.push(val2 + val1);
			        break;
			        
			        case '-':
			        	stack.push(val2 - val1);			      
				    break;
				    
			        case '*':
			        	stack.push(val2 * val1);	
			        	break;
			        
			        case '/':
			        	stack.push(val2 / val1);	
			        	break;
			        	 
					}
			}
		}
		return stack.pop();
	}

		public static void main(String[] args) {
			String input = new String();
			input = "(4+8)*(8-4)/((6-2*2)*(1+2))";
			printInfix(input);
			printPostfix(input);
			printFinalResult(input);
	        
			
		}
}
