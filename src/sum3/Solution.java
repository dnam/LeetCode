package sum3;

import java.util.*;

public class Solution {
	public static void main(String[] args) {
		int[] a = {-1, -1, -1, -1 ,0, 0, 0, 0, 1, 2, 2, 2, 2, 2, -1, -4, -4, -4 , -4, -4};
//		int[] a = {-4,-2,1,-5,-4,-4,4,-2,0,4,0,-2,3,1,-5,0};
		Arrays.sort(a);;
		for(int i = 0; i < a.length; i++)
			System.out.print(a[i] + " ");
		System.out.println();
		System.out.println((new Solution()).threeSum(a));
	}
	
	public ArrayList<ArrayList<Integer>> threeSum(int[] num) {
		ArrayList<ArrayList<Integer>> list = new ArrayList<ArrayList<Integer>>();
		
		Arrays.sort(num);
		
		// extract at most 2 elements if duplicated. 3 for 0s		
		for (int i = 0; i < num.length; i++) {
			if (i > 0 && num[i] == num[i-1])
				continue;
			
			int start = i + 1;
			int end = num.length - 1;
			
			while (start < end) {
				int sum = num[i] + num[start] + num[end];
				if (sum > 0) {
					end--;
				} else if (sum < 0) {
					start++;
				} else { // sum == 0
					// skip duplicated results
					if ((start > (i+1) && num[start] == num[start - 1])
							|| (end + 1 < num.length && num[end] == num[end + 1])) {
						start++;
						end--;
						continue;
					}

					ArrayList<Integer> curList = new ArrayList<Integer>(3);
					curList.add(num[i]);
					curList.add(num[start]);
					curList.add(num[end]);
					list.add(curList);

					start++;
					end--;
				}
			}
		}
		
		return list;
    }
}
