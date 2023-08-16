class Solution {
    public double findMaxAverage(int[] nums, int k) {
        double maxSum = Integer.MIN_VALUE;
        int currSum = 0;
        int r = 0;
        while(r < k){
            currSum += nums[r];
            r++;
        }
        r--;
        int l = 0;

        maxSum = currSum;

        while(r < nums.length - 1)
        {
            currSum = currSum + nums[r+1] - nums[l];
            l++;
            r++;
            maxSum = Math.max(currSum, maxSum);
            
        }
        return (double)maxSum/k;

    }
}