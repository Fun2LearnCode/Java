public class Calculator{
    private int x;
    private int y;

    public Calculator(){

    }
    private int addition(){
    	return x + y;
    }
    private int subtraction(){
    	return x - y;
    }
    private int multiply(){
    	return x * y;
    }
    private int divide(){
    	return x / y;
    }
    public int toBinary(){ // Task 3
        return Integer.parseInt(Integer.toString(x,2))); // this must return an int, so its pretty bad
    }
    public int solve(int x, char operator, int y){
    	this.x = x;
    	this.y = y;
    	switch(operator){
    		case '+':
    			return addition();
    		case '-':
    			return subtraction();
    		case '*':
    			return multiply();
    		case '/':
    			return divide();
    		case '\\': // \ is an escape character, so it cannot be put into a string, adding a second negates the effect
                       // this is the same as putting " inside a string.
    			return divide();
            case 'b'                // Task 3
                return toBinary();  // Task 3

    	}
    	return 0;
    }

}
