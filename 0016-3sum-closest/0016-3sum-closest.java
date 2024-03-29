class Solution {
    public int threeSumClosest(int[] nums, int target) {
        int diff = Integer.MAX_VALUE;
        int sum = 0;
        Arrays.sort(nums);
        // make i fixed
        for (int i = 0; i < nums.length; i++) {
            // two pointers for comparing values greater than i 
            int j = i+1;
            int k = nums.length-1;
            
            // use two pointers j and k for every i
            while (j < k) {
                sum = nums[i] + nums[j] + nums[k];
                if (Math.abs(target-sum) < Math.abs(diff)) {
                    diff = target-sum;
                }
                if (sum < target) { // if our sum is lower than target, we want to move closer
                    j++;
                }
                else{ // if our sum is farther than target, we want to move closer
                    k--;
                }          
            }

        }
        return target-diff; // target - diff is the most optimal sum, or we can use extra variable to store Best sum
    }
}