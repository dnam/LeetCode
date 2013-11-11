package restoreIP;

import java.util.*;

public class Solution {
	public ArrayList<String> restoreIpAddresses(String s) {
		return restorePartIP(s.toCharArray(), 0, 4);
    }
	
	public ArrayList<String> restorePartIP(char[] s, int start, int remParts) {
		ArrayList<String> lst = new ArrayList<String>();
		String cur = "";
		
		// too many characters
		if (start >= s.length || s.length - start > 3*remParts)
			return lst;	// return empty list
		
		// Only one part
		if (remParts == 1) {
			if (!isValid(s, start, s.length - 1))
				return lst; // empty list
			
			for (int i = start; i < s.length; i++) {
				cur += s[i];
			} // end for
			lst.add(cur);
			
			return lst;
		} // end if
		
		// try to generate all possible combinations
		for (int i = start; i < start + 3 && i < s.length; i++) {
			cur += s[i];
			if (isValid(s, start, i)) {
				ArrayList<String> subLst = restorePartIP(s, i + 1, remParts - 1);
				for (String str: subLst) {
					lst.add(cur + "." + str);
				}
			} else {
				break;
			} // end if
		} // end for
		
		return lst;
	}

	public boolean isValid(char[] s, int begin, int end) {
		// 1 digit
		if (begin == end) {
			return true;
		} // end if
		
		// 2 digits
		if (begin + 1 == end) {
			return (s[begin] != '0');
		}
		
		// 3 digits
		switch (s[begin]) {
		case '0': // begins with 0
			return false;
		case '1':
			return true;
		case '2': // must be smaller or equal to 255
			if ((s[begin + 1] > '5')
					|| (s[begin + 1] == '5' && s[begin + 2] > '5'))
				return false;
			return true;
		} // end switch

		// other cases
		return false;
	}
}
