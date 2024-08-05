class Solution {
    int[] nums;
    public int rob(int[] nums) {
        this.nums = nums;

        if(nums.length == 1)
        {
            return nums[0];
        }

        int[] dp = new int[nums.length]; //stores at index i, the best robbing value from the left up to i;
        dp[0] = nums[0];
        dp[1] = nums[1];
        dp[2] = nums[0] + nums[2];

        //dp = [1, 2, 4];
        int max = Math.max(dp[1], dp[2]);
        for(int i = 3; i < nums.length; i++)
        {
            dp[i] = Math.max(dp[i-2], dp[i-3]) + nums[i];
            max = Math.max(max, dp[i]);
        }

        // System.out.println(Arrays.toString(dp));

        return max;
    }

    int recur(int i)
    {
        if(i >= nums.length)
        {
            return 0;
        }

        return nums[i] + Math.max(recur(i+2), recur(i+3));
    }
}