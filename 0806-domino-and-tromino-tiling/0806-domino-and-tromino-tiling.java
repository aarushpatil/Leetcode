class Solution {
    public int numTilings(int n) {
        //dp[i] is the number of ways to do when n is i.

        //dp[0] is 0
        //dp[1] is 1
        //dp[2] is 2
        //dp[3] is 5
        int mod = ((int)Math.pow(10, 9)) + 7;
        int[] dp = new int[n + 5];
        dp[0] = 0;
        dp[1] = 1;
        dp[2] = 2;
        dp[3] = 5;
        
        
        dp[4] = 11;

        for(int i = 4; i < n + 1; i++)
        {
            // for(int k = i - 1; k >= i/2; k--)
            {
                dp[i] = ((dp[i - 3] % mod) + ((2 * dp[i - 1]) % mod)) % mod;
            }
        }

        return dp[n];
    }
}