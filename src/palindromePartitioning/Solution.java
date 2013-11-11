package palindromePartitioning;
import java.util.*;

public class Solution {
	public static void main(String[] args) {
		Solution sol = new Solution();
		System.out.println(sol.partition("baab"));
	}
    public ArrayList<ArrayList<String>> partition(String s) {
    	ArrayList<ArrayList<String>> retLst = new ArrayList<ArrayList<String>>();
    	if (s.length() == 0) return retLst;
    	if (s.length() == 1) {
    		ArrayList<String> lst = new ArrayList<String>();
    		lst.add(s);
    		retLst.add(lst);
    		return retLst;
    	}
    	
    	// Try to find a palindrome starting from 0
    	int end = 0;
    	while (end < s.length()) {
    		if ((s.charAt(end) != s.charAt(0)) || !isPalindrome(s, 0, end)) {
    			end++;
    			continue;
    		} else if (end + 1 == s.length()) { // whole string
    			ArrayList<String> lst = new ArrayList<String>();
    			lst.add(s);
    			retLst.add(lst);
    		} else { // 0 -> end is a palindrome. do the rest
				// 0 to s is a palindrome
				ArrayList<ArrayList<String>> substrLsts = partition(s.substring(end + 1));
				if (substrLsts != null) {
					for (ArrayList<String> subLst : substrLsts) {
						ArrayList<String> lst = new ArrayList<String>();
						lst.add(s.substring(0, end + 1));
						lst.addAll(subLst);
						retLst.add(lst);
					} // end for
				} // end if

    		} // end if
    		end++;
    	} // end while
    	
    	return retLst;
    }
    
    public boolean isPalindrome(String s, int start, int end) {
    	while (start < end) {
    		if (s.charAt(start) == s.charAt(end)) {
    			start++;
    			end--;
    		} else {
    			return false;
    		} // end if
    	} // end while
    	return true;
    }
}