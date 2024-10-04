class Solution {
    public int lengthOfLIS(int[] nums) {

        int[] dp = new int[nums.length];
        for(int i = 1; i < nums.length; i++)
        {
            for(int k = i - 1; k >= 0; k--)
            {
                if(nums[k] < nums[i])
                {
                    dp[i] = Math.max(dp[i], dp[k] + 1);
                }
            }
        }
        System.out.println(Arrays.toString(dp));

        int max = 0;
        for(int i : dp)
        {
            max = Math.max(max, i);
        }

        return max + 1;
    }
}