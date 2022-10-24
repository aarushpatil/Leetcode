class Solution {
    public int maxSubArray(int[] nums) {
// //brute force approach 
//         int maxSum = nums[0];
//         for(int i = 0; i < nums.length; i++){
//             if(nums[i] > maxSum){
//                 maxSum = nums[i];
//             }
//         }
//         for(int left = 0; left < nums.length; left++){
//             int currSum = nums[left];
//             for(int right = left+1; right < nums.length; right++){                
//                 //manage currSum
//                 currSum += nums[right];
//                 if(currSum > maxSum){
//                     maxSum = currSum;
//                 }
//             }
            
//         }
//         return maxSum;
        
        
        
        //Kadane's algorithm
        int max = Integer.MIN_VALUE;
        int subMax = -10^5;
        for(int i = 0; i < nums.length; i++){
            subMax = Math.max(nums[i], nums[i] + subMax);
            if(max < subMax){
                max = subMax;
            }
        }
        return max;
    }
}