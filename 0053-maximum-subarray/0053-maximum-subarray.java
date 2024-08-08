class Solution {
    public int maxSubArray(int[] nums) {
      int curSum = 0;
      int n = nums.length;
      int maxSum = Integer.MIN_VALUE;
      for (int i = 0; i < n; i++) {
        if (curSum < 0) {
          curSum = 0;
        }
        curSum += nums[i];
        if (curSum > maxSum) {
          maxSum = curSum;
        }
      }
      return maxSum;
    }
}