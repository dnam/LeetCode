package validNumber;
import java.util.regex.*;

public class Solution {
	public static void main(String[] args) {
		Solution sol = new Solution();
		System.out.println(sol.isNumber(""));
	}
	
    public boolean isNumber(String s) {
    	char[] sChar = s.trim().toCharArray();
    	
    	boolean isNum = false;		/* is this a number yet? */
    	boolean isDecimal = false;	/* does it contain decimal */
    	boolean isExp = false;		/* does it contain exponential? */
    	boolean isValidExp = true;	/* is it a valid exponential */
    	for (int i = 0; i < sChar.length; i++) {
    		char c = sChar[i];
    		
    		// filter out invalid characters
    		if ((c < '0' || c > '9') && c != 'e' && c != '.' && c != '-' && c != '+')
    			return false;
    		
    		// Handle signs: +03.2 and 3.e-4
    		if (c == '-' || c == '+') {
    			if (i == 0 || (isExp && !isValidExp)) 
    				continue;
    			
    			return false;
    		}
    		
    		// Decimal sign: must be before 'e'
    		if (c == '.') {
    			if (isDecimal || isExp) { // if there was another dot, or dot after e
    				return false;
    			}
    			
    			isDecimal = true;
    			continue;
    		}
    		
    		// Exponential sign
    		if (c == 'e') {
    			// filter "e03" or "1e3e3"
    			if (!isNum || isExp) {
    				return false;
    			}
    			
    			isExp = true;
    			isValidExp = false;
    			continue;
    		}
    		
    		// c is a digit
    		if (isExp && !isValidExp) {
    			isValidExp = true;
    		}
    		
    		// not a number yet?
    		if (!isNum)
    			isNum = true;
    	}
  
    	return (isValidExp && isNum);
    }
}