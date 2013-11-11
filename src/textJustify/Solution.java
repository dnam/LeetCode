package textJustify;
/*
 * Accepted
 */

import java.util.ArrayList;

public class Solution {
	public static void main(String[] args) {
		String[] words = {"Listen","to","many,","speak","to","a","few."};
		ArrayList<String> justified = (new Solution()).fullJustify(words, 6);
		for (String s: justified) {
			System.out.println("\"" + s + "\"");
		}
	}
	
    public ArrayList<String> fullJustify(String[] words, int L) {
    	ArrayList<String> justifiedText = new ArrayList<String>();
    	
    	int curLen = 0; /* current line's length */
    	ArrayList<String> curLine = new ArrayList<String>();
    	for (int i = 0; i < words.length; i++) {
    		if (curLen == 0) {
    			curLen = words[i].length();
    			curLine.add(words[i]);
    		} else if (curLen + 1 + words[i].length() <= L) {
    			curLen += (1 + words[i].length()); // at least a space between words
    			curLine.add(words[i]);
    		} else { /* we have to create a new line */
    			String line = makeString(curLine, curLen, L);
    			justifiedText.add(line);
    			
    			/* Reset the data */
    			curLine.clear();
    			curLine.add(words[i]);
    			curLen = words[i].length();
    		}
    	}
    	
    	if (curLine.size() > 0) { /* Left over data */
    		StringBuilder strBld = new StringBuilder();
    		for (int i = 0; i < curLine.size(); i++) {
    			strBld.append(curLine.get(i));
    			if (i + 1 < curLine.size()) {
    				strBld.append(" ");
    			}
    		}
    		
    		for (int i = 0; i < (L - curLen); i++) 
    			strBld.append(" ");
    		
    		justifiedText.add(strBld.toString());
    	}
    	
    	return justifiedText;
    }
    
    public String makeString(ArrayList<String> curLine, int curLen, int L) {
    	StringBuilder strBld = new StringBuilder();
    	if (curLine.size() == 1) {
    		strBld.append(curLine.get(0));
    		for (int i = 0; i < L - curLen; i++) {
    			strBld.append(" ");
    		}
    		return strBld.toString();
    	}
    	
    	int extraPerWord = (L - curLen)/(curLine.size() - 1);
		int extraForLeft = (L - curLen) % (curLine.size() - 1);
		for (int i = 0; i < curLine.size(); i++) {
			strBld.append(curLine.get(i));
			if (i + 1 < curLine.size()) {
				strBld.append(" ");
				
				for (int k = 0; k < extraPerWord; k++) 
					strBld.append(" ");
				
				if (extraForLeft-- > 0) strBld.append(" ");
			}
		}
		
		return strBld.toString();
    }
}
