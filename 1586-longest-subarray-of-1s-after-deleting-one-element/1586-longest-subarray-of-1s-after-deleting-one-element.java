class Solution {
    public int longestSubarray(int[] nums) {
        int l = 0;
        int r = 0;
        boolean removed = false;
        int max = 0;
        int prevZero = 0;

        while(r < nums.length)
        {
            if(nums[r] == 0)
            {
                
                if(!removed)
                {
                    removed = true;
                }
                else
                {
                    l = prevZero + 1;
                }
                prevZero = r;
            }
            max = Math.max(max, r - l);
            r++;
        }

        return max;

        
    }
}