import java.util.Stack;

/**
 * The main part of the calculator doing the calculations.
 * 
 * @author  M. Kolling 
 * @version 0.1 (incomplete)
 * @editedBy Ciaran Roche
 * @date 23/01/2017
 */
public class CalcEngine
{
    char operator;
    int displayValue, operand1;
    

    public Stack<Character>stack;
    /**
     * Create a CalcEngine instance. Initialise its state so that it is ready 
     * for use.
     */
    public CalcEngine()
    {
    	stack = new Stack<Character>();
    }
  
    public String infixToPostfix(String s){
		for(int i = 0; i< s.length(); i++){
			char ch = s.charAt(i);
			switch (ch){
			case '+':
			case '-':
				operand(ch, 1);
				break;
			case '*':
			case '/':
				operand(ch, 2);
				break;
			case '(':
				stack.push(ch);
				break;
			case ')':
				parentise(ch);
				break;
				default:
					output = output + ch;
					break;
			}
		}
		while(!stack.isEmpty()){
			output = output + stack.pop();
		}
		System.out.println(output);
    	return output;
    	
    }
    
    public String output= "";
    
    public void operand(char opThis, int prec1){
    	while(!stack.isEmpty()){
    		char topStack = stack.pop();
    		if (topStack == '('){
    			stack.push(topStack);
    			break;
    		}else{
    			int prec2;
    			if(topStack == '+' || topStack == '-')
    				prec2 = 1;
    			else
    				prec2 = 2;
    			if(prec2 < prec1){
    				stack.push(topStack);
    				break;
    			}else output = output + topStack;
    		}
    	}
    	stack.push(opThis);
    }
    
    public void parentise(char ch){
    	while(!stack.isEmpty()){
    		char cha = stack.pop();
    		if (cha == '(')
    			break;
    		else output = output + cha;
    	}
    }

    /**
     * The 'plus' button was pressed. 
     */
    public void plus()
    {
       operand1 = displayValue;
	   displayValue = 0;
       operator = '+';
    }
    
    /**
     * The 'minus' button was pressed.
     */
    public void minus()
    {
        operand1 = displayValue;
	   displayValue = 0;
       operator = '-'; 
    }

public void multiply()
    {
        operand1 = displayValue;
	   displayValue = 0;
       operator = '*'; 
    }

public void divide()
    {
        operand1 = displayValue;
	   displayValue = 0;
       operator = '/'; 
    }

    /**
     * The '=' button was pressed.
     */
    public void equals()
    {
        if (operator == '+') {
			displayValue += operand1;
			operand1 = 0;
		}
	    else if (operator == '-') {
			displayValue = operand1-displayValue;
			operand1 = 0;
		}
		else if (operator == '*') {
			displayValue = operand1*displayValue;
			operand1 = 0;
		}
		else if (operator == '/') {
			displayValue = operand1/displayValue;
			operand1 = 0;
		}

    }

    /**
     * The 'C' (clear) button was pressed.
     */
    public void clear()
    {
        displayValue = 0;
		operand1 = 0;

    }

    /**
     * Return the title of this calculation engine.
     */
    public String getTitle()
    {
        return("Not So Scientific Calculator");
    }

    /**
     * Return the author of this engine. This string is displayed as it is,
     * so it should say something like "Written by H. Simpson".
     */
    public String getAuthor()
    {
        return("Ciaran Roche");
    }

    /**
     * Return the version number of this engine. This string is displayed as 
     * it is, so it should say something like "Version 1.1".
     */
    public String getVersion()
    {
        return("Ver. 1.0");
    }

}
