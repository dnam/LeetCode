package longestValidParenthesis;

import java.util.*;

public class Solution {
	public static void main(String[] args) {
		System.out.println((new Solution()).longestValidParentheses("((()()))(()"));
	}
	
    public int longestValidParentheses(String s) {
    	char[] sChar = s.toCharArray();
    	boolean[] match = new boolean[sChar.length];
    	Arrays.fill(match, false);
    	
    	Stack<Integer> stack = new Stack<Integer>();
    	for (int i = 0; i < sChar.length; i++) {
    		if (sChar[i] == '(') {
    			stack.push(i);
    		} else if (!stack.isEmpty()) {
    			int last = stack.pop();
    			match[last] = match[i] = true;
    		}
    	}
    	
    	int maxLen = 0;
    	int lastPos = 0;
    	for (int i = 0; i < match.length; i++) {
    		if (!match[i]) {
    			lastPos = i+1;
    		}
    		
    		maxLen = Math.max(maxLen, i - lastPos + 1);
    	}
        return maxLen;
    }
    
}