package restoreIP;

import static org.junit.Assert.*;

import org.junit.Test;

public class SolutionTest {

	@Test
	public void test() {
		Solution sol = new Solution();
	
		assertEquals("isValid", true, sol.isValid("123".toCharArray(), 0, 2));
		assertEquals("isValid", true, sol.isValid("255".toCharArray(), 0, 2));
		assertEquals("isValid", false, sol.isValid("256".toCharArray(), 0, 2));
		assertEquals("isValid", false, sol.isValid("258".toCharArray(), 0, 2));
		assertEquals("isValid", false, sol.isValid("345".toCharArray(), 0, 2));
		
		
		assertEquals("restorePartIP", "255.255.11.135", sol.restorePartIP("25525511135".toCharArray(), 0, 4).get(0));
		System.out.println(sol.restorePartIP("010010".toCharArray(), 0, 4));
	}

}
