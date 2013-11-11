package jumpGame;

import java.util.Arrays;

public class Solution {
	public static void main(String[] args) {
		Solution sol = new Solution();
		int[] a = {2,2,0,1};
		System.out.println(sol.jump(a));
	}
	
	public int jump(int[] A) {
		// A.length == 1?
		int[] jcnt = new int[A.length];
		Arrays.fill(jcnt, 0);
		
		int maxReach = 0;
		int lastReach = 0;
		while(maxReach < A.length - 1) {
			int curReach = maxReach;
			for (int i = lastReach; i <= maxReach; i++) {
				if (i + A[i] > maxReach) {
					for (int j = maxReach + 1; j < A.length && j <= i + A[i]; j++) {
						jcnt[j] = jcnt[i] + 1;
					} // end for loop
					
					if (i + A[i] > curReach)
						curReach = i + A[i];
				} // end if
			} // end for
			
			lastReach = maxReach;
			maxReach = curReach;
		} // end while
        return jcnt[A.length - 1];
    }
}
