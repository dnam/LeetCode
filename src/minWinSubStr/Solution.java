package minWinSubStr;

import java.util.Arrays;

/*
 * Given a string S and a string T, find the minimum window in S which will contain all the characters in T in complexity O(n).

 For example,
 S = "ADOBECODEBANC"
 T = "ABC"
 Minimum window is "BANC".

 Note:
 If there is no such window in S that covers all characters in T, return the emtpy string "".

 If there are multiple such windows, you are guaranteed that there will always be only one unique minimum window in S.
 */
public class Solution {
	public String minWindow(String S, String T) {
		int sLen = S.length();
		int tLen = T.length();
		int[] needToFind = new int[256];
		int[] hasFound = new int[256];
		Arrays.fill(needToFind, 0);
		Arrays.fill(hasFound, 0);
		
		char[] sChar = S.toCharArray();
		char[] tChar = T.toCharArray();
		
		for (int i = 0; i < tLen; i++)
			needToFind[tChar[i]]++;
		
		int minWindowBegin = -1;
		int minWindowEnd = -1;
		int minWindowLen = Integer.MAX_VALUE;
		int count = 0;
		
		for (int begin = 0, end = 0; end < sLen; end++) {
			// skip characters not in T
			if (needToFind[sChar[end]] == 0) continue;
			hasFound[sChar[end]]++;
			if (hasFound[sChar[end]] <= needToFind[sChar[end]])
				count++;
			
			// if window constraint is satisfied
			if (count == tLen) {
				// advance begin index index as far right as possible
				// stop when advancing breaks window constraint.
				while (needToFind[sChar[begin]] == 0 || 
						hasFound[sChar[begin]] > needToFind[sChar[begin]]) {
					if (hasFound[sChar[begin]] > needToFind[sChar[begin]])
						hasFound[sChar[begin]]--;
					begin++;
				}
				
				// update window if a minimum length is met
				int windowLen = end - begin + 1;
				if (windowLen < minWindowLen) {
					minWindowBegin = begin;
					minWindowEnd = end;
					minWindowLen = windowLen;
				} //end if
			} // end if
		} // end for
		
		//System.out.println("Begin: " + minWindowBegin + " end: " + minWindowEnd);
		return (count == tLen)? S.substring(minWindowBegin, minWindowEnd + 1): "";
    }
}
