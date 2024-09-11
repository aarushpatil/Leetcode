class Solution {
    public int coinChange(int[] coins, int amount) {
        int n = amount;
        int[] dp = new int[n + 1]; //represents min # of coins to get to it
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0] = 0;
        for(int i = 0; i < dp.length; i++)
        {
            for(int k = 0; k < coins.length; k++)
            {
                if(i - coins[k] >= 0)
                {
                    dp[i] = (int) Math.min((long)dp[i], ((long)dp[i - coins[k]]) + 1);
                }
            }
        }

        return (dp[amount] == Integer.MAX_VALUE) ? -1 : dp[amount];
    }
}