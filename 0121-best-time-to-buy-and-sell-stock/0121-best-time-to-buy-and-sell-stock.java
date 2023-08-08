class Solution {
    public int maxProfit(int[] prices) {
        int maxProfit = 0;
        int min = prices[0];
        for(int i = 1; i < prices.length; i++){//i=2
            maxProfit = Math.max(prices[i] - min, maxProfit);//4
            min = Math.min(min, prices[i]);//1
        }
        return maxProfit;
    }
}