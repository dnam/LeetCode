package validPalindrome;

import static org.junit.Assert.*;

import org.junit.Test;

public class SolutionTest {

	@Test
	public void test() {
		Solution sol = new Solution();
		
		assertEquals("A man, a plan, a canal: Panama", true, sol.isPalindrome("A man, a plan, a canal: Panama"));
		assertEquals("Empty String", true, sol.isPalindrome(""));
		assertEquals("race a car", false, sol.isPalindrome("race a car"));
		assertEquals("this is a tests et asi si ht", true, sol.isPalindrome("this is a tests et asi si ht"));
	}

}
