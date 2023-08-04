class Solution {
    public int maxProduct(int[] nums) {
        int currMax = nums[0];//18
        int currMin = nums[0];//-9
        int max = nums[0];//18
        for(int i = 1; i < nums.length; i++){// 3 < 4
            int temp = Math.max(Math.max(nums[i], nums[i] * currMax), nums[i] * currMin);
            currMin = Math.min(Math.min(nums[i], nums[i] * currMin), nums[i] * currMax);
            currMax = temp;
            max = Math.max(currMax, max);
        }
        return max;
   }
}