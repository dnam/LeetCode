package validPalindrome;

public class Solution {
    public boolean isPalindrome(String s) {
    	char[] strArr = s.toLowerCase().toCharArray();
    	
    	int begin = 0;
    	int end = strArr.length - 1;
    	while (begin < end) {
    		boolean skip = false;
    		if (!isValidChar(strArr[begin])) {
    			begin++;
    			skip = true;
    		} // end if
    		
    		if (!isValidChar(strArr[end])) {
    			end--;
    			skip = true;
    		} // end if
    		
    		if (skip) continue;
    		
    		if (strArr[begin] == strArr[end]) {
    			begin++;
    			end--;
    		} else
    			return false;
    	}
    	
    	return true;
    }
    
    /**
     * Check the validity of a character
     * @param c character to check
     * @return true if the character is a lowercase alphabetic letter
     */
    public boolean isValidChar(char c) {
    	return ((c >= 'a' && c <= 'z') || (c >= '0' && c <= '9'));
    }
}