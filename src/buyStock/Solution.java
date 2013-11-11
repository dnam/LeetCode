package buyStock;

public class Solution {
    public int maxProfit(int[] prices) {
    	if (prices.length < 2) 
    		return 0;
    	
    	int[] mins = new int[prices.length];
    	int[] maxs = new int[prices.length];
    	
    	mins[0] = prices[0];
    	for (int i = 1; i < prices.length; i++) {
    		mins[i] = (mins[i-1] < prices[i])? mins[i-1] : prices[i];
    	}
    	
    	maxs[prices.length - 1] = prices[prices.length - 1];
    	for (int i = prices.length - 2; i >= 0; i--) {
    		maxs[i] = (maxs[i+1] > prices[i])? maxs[i+1]: prices[i];
    	}
    	
    	int maxProfit = maxs[0] - mins[0];
    	for (int i = 1; i < prices.length; i++) {
    		int curProfit = maxs[i] - mins[i];
    		if (maxProfit < curProfit)
    			maxProfit = curProfit;
    	}
    	
    	return maxProfit;
    }
}