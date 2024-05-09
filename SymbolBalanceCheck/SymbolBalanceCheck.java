package Assignment2;
import java.util.Stack;

//3.21 Write a program to check for balancing symbols in the following languages:
//b. Java (/* */, (), [], {} )


public class SymbolBalanceCheck {
	
	//Returns true if the symbol is an open symbol
    private static boolean symbolDirection(String symbol) {
        if (symbol.equals("(") || symbol.equals("[") || symbol.equals("{") || symbol.equals("/*") )
    	return true;
    	return false;
    }
    //Returns true if the two given string is the same
    private static boolean isMatching(String open, String close) {
        return (open.equals("(") && close.equals(")")) || (open.equals("[") && close.equals("]"))||
        		(open.equals("{") && close.equals("}")) || (open.equals("/*") && close.equals("*/"));
    }
    public static boolean isBalanced(String str) {
        Stack<String> stack = new Stack<>();						//Creates a String stack called stack

        for (int i=0;i< str.length(); i++) { 						//Traverse through each character in the given string of symbols
        	String temp="";
        	if(str.charAt(i) == ' ')								//Skips character if the character equals to " "
        		i++;
        	
        	if(str.charAt(i) == ('/') || str.charAt(i) == ('*')  ) {//Since /* counts as one symbol but have two character, make a special 
        															//case to put the two character into one stack
        		if(str.charAt(i+1) == ('*') || str.charAt(i+1) == ('/') )
        		{
        			temp= str.substring(i,i+2);
        			i++;
        		}
        	}else {
        		temp = str.substring(i,i+1);						//If not /* or */, puts character into temp string
        	}
        	if (symbolDirection(temp) ) {							//If the symbol is one of the open symbols, push onto stack
                 stack.push(temp);                  
            }else{													//If not, check if the character matches with the symbol on top of 
            														//the stack
                if (stack.isEmpty() || !isMatching(stack.pop(), temp)) {
                    return false; 									//Return false if two character do not match
                }
            }
        }

        return stack.isEmpty(); 									//Return true if all symbols has been matched and popped
    }
    //The Main Method
    public static void main(String[] args) {
        //Given Test cases
        String[] array = new String[8];
        array[0] = "/* {[]} */";
        array[1] = "{[()]}";
        array[2] = "()[]{}";
        array[3] = "{[)]";
        array[4] = "/*";
        array[5] = "([)";
        array[6] = "{/* */}";
        array[7] = "/* {} */";

        for(String value : array) {
            System.out.println("String tested: " + value);
            if (isBalanced(value)) {
                System.out.println("The follwing symbol string are balanced !!\n");
            } else {
                System.out.println("The follwing symbol string are not balanced :(\n");
            }
            
        }
    }

}
