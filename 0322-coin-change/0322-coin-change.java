class Solution {
    long[] dp;
    int[] coins;
    public int coinChange(int[] coins, int amount) {
        if(amount <= 0) return amount;
        this.coins = coins;
        dp = new long[amount + 1]; // try using a map for this...
        return helper(amount);
    }

    int helper(int amount)
    {
        if(amount < 0) 
        {
            return -1;
        }
        else if(amount == 0) return 0;

        else if(dp[amount] != 0) return (int)dp[amount];

        long min = Integer.MAX_VALUE;
        for(int c : coins)
        {
            
            long res = helper(amount - c);
            if(res != -1)
            {
                min = Math.min(res + 1, min);
            }
        }
        int retVal = 0;
        if(min >= Integer.MAX_VALUE) retVal = -1;
        else retVal = (int)min;
        dp[amount] = retVal;
        return retVal;
    }
}