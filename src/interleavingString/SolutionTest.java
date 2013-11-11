package interleavingString;

import static org.junit.Assert.*;

import org.junit.Test;

public class SolutionTest {

	@Test
	public void test() {
		Solution sol = new Solution();
		assertEquals(true, sol.isInterleave("aabcc", "dbbca", "aadbbcbcac"));
		assertEquals(false, sol.isInterleave("aabcc", "dbbca", "aadbbbaccc"));
	}

}
