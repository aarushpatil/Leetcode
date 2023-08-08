class Solution {
    public int maxProfit(int[] prices) {
        int min = prices[0];
        int max = 0;

        int maxVal = 0;
        for(int i = 1; i < prices.length; i++)
        {
            if(min > prices[i])
            {
                min = prices[i];
                max = prices[i];
            }
            max = Math.max(max, prices[i]);
            maxVal = Math.max(maxVal, max - min);
        }
        return maxVal;
    }
}