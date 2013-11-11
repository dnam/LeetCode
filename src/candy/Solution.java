package candy;

import java.util.Arrays;

public class Solution {
	public static void main(String[] args) {
		Solution sol = new Solution();
		int[] a = {1,2,2};
		System.out.println(sol.candy(a));
	}
	
	public int candy(int[] ratings) {
		if (ratings == null || ratings.length == 0) 
			return 0;
		
		int len = ratings.length;
		int[] leftGaps = new int[len];
		int[] rightGaps = new int[len];
		
		leftGaps[0] = 0;
		for (int i = 1; i < ratings.length; i++) {
			if (ratings[i] > ratings[i-1]) {
				leftGaps[i] = leftGaps[i-1]+1;
			} else {
				leftGaps[i] = 0;
			}
		}
		
		rightGaps[len - 1] = 0;
		for (int i = len - 2; i >= 0; i--) {
			if (ratings[i] > ratings[i+1]) {
				rightGaps[i] = rightGaps[i+1] + 1;
			} else {
				rightGaps[i] = 0;
			}
		}
		
		int noCandy = len;
		for (int i = 0; i < len; i++) {
			noCandy += Math.max(leftGaps[i], rightGaps[i]);
		}

		return noCandy;
    }
}
