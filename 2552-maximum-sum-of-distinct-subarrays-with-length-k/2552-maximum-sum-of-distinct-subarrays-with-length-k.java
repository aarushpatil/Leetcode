class Solution {
    public long maximumSubarraySum(int[] nums, int k) {
        HashSet<Integer> inWindow = new HashSet<>();
        HashMap<Integer, Integer> inWindowFreq = new HashMap<>();

        long maxSum = 0;
        long currSum = 0;

        for(int i = 0; i < k; i++)
        {
            currSum += nums[i];
            inWindow.add(nums[i]);
            inWindowFreq.put(nums[i], inWindowFreq.getOrDefault(nums[i], 0) + 1);
        }

        if(inWindow.size() == k) maxSum = Math.max(maxSum, currSum);


        for(int i = k; i < nums.length; i++)
        {
            //remove leftside
            currSum -= nums[i - k];
            if(inWindowFreq.get(nums[i - k]) == 1)
            {
                inWindow.remove(nums[i - k]);
                inWindowFreq.remove(nums[i - k]);
            }
            else
            {
                inWindowFreq.put(nums[i - k], inWindowFreq.get(nums[i - k]) - 1);
            }

            //add rightside
            currSum += nums[i];
            inWindow.add(nums[i]);
            inWindowFreq.put(nums[i], inWindowFreq.getOrDefault(nums[i], 0) + 1);
            
            if(inWindow.size() == k) maxSum = Math.max(maxSum, currSum);
        }

        return maxSum;
    }
}