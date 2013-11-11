package interleavingString;

import java.util.Arrays;

public class Solution {
    public boolean isInterleave(String s1, String s2, String s3) {
    	int l = s1.length();
    	int m = s2.length();
    	int n = s3.length();
    	
    	if (l + m != n)
    		return false;
    	
    	boolean[][] matching = new boolean[l+1][m+1];
    	for (int i = 0; i < l + 1; i++)
    		Arrays.fill(matching[i], false);
    	
    	// initialize the matching array. s1 = "" or s2== "" will fail
    	matching[0][0] = true;
    	for (int i = 1; i <= l; i++) {
    		matching[i][0] = (matching[i-1][0] && (s1.charAt(i-1) == s3.charAt(i-1)));
    	}
    	
    	for (int i = 1; i <= m; i++) {
    		matching[0][i] = (matching[0][i-1] && (s2.charAt(i-1) == s3.charAt(i-1)));
    	}
    	
    	// Now start the dynamic program
    	for (int i = 1; i < l+1; i++) {
    		for (int j = 1; j < m+1; j++) {
    			matching[i][j] = (matching[i-1][j] && (s1.charAt(i-1) == s3.charAt(i + j-1))) ||
    								 (matching[i][j-1] && (s2.charAt(j-1) == s3.charAt(i + j-1)));
    		}
    	}
    
    	return matching[l][m];
    }
    
}
