package trappingWater;

import java.util.Arrays;

public class Solution {
	public static void main(String[] args) {
		Solution sol = new Solution();
		int[] a = {0,1,0,2,1,0,1,3,2,1,2,1};
		System.out.println(sol.trap(a));
	}
	
	public int trap(int[] A) {
		if (A.length < 1)
			return 0;
		
		int[] left = new int[A.length];
		int[] right = new int[A.length];
		int[] water = new int[A.length];
		Arrays.fill(water, 0);
		
		
		left[0] = A[0];
		for (int i = 1; i < A.length; i++) {
			left[i] = (left[i-1] > A[i])? left[i-1] : A[i];
		}
		
		right[A.length - 1] = A[A.length - 1];
		for (int i = A.length - 2; i >= 0; i--) {
			right[i] = (right[i+1] > A[i])? right[i+1]: A[i];
		}
		
		// fill up the water
		for (int i = 0; i < A.length; i++) {
			if (left[i] > A[i] && right[i] > A[i]) {
				water[i] = Math.min(left[i], right[i]) - A[i];
			}
			else
				water[i] = 0;
		}
		
		// sum up
		int sumWater = 0;
		for (int i = 0; i < water.length; i++)
			sumWater += water[i];
		
		return sumWater;
    }
}
