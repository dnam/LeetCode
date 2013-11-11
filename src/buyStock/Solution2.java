package buyStock;

public class Solution2 {
	public static void main(String[] args) {
		Solution2 sol = new Solution2();
		int[] a = {1, 4, 2};
		System.out.println(sol.maxProfit(a));
	}
	public int maxProfit(int[] prices) {
		// [lastLoc .. curLoc] is a non-decreasing interval
		int lastLoc = 0;
		int curLoc = 0;
		
		int curProfit = 0;
		while (curLoc < prices.length) {
			if (curLoc + 1 < prices.length && prices[curLoc + 1] >= prices[curLoc]) {
				curLoc++;
				continue;
			} // end if
			
			// prices[curLoc + 1] < prices[curLoc]
			curProfit += (prices[curLoc] - prices[lastLoc]);
			curLoc++;
			lastLoc = curLoc;
		} // end while
		
        return curProfit;	
    }
}
