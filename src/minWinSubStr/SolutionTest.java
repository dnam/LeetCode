package minWinSubStr;

import static org.junit.Assert.*;

import org.junit.Test;

public class SolutionTest {

	@Test
	public void test() {
		Solution sol = new Solution();
		
		assertEquals("cabeca cae|3 5 eca|", "eca", sol.minWindow("cabeca", "cae"));
		assertEquals("cabefgecdaecf cae|9 11 aec", "aec", sol.minWindow("cabefgecdaecf", "cae"));
		assertEquals("caaec cae|2 4 aec", "aec", sol.minWindow("caaec", "cae"));
	}

}
