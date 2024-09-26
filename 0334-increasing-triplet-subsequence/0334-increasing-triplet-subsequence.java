class Solution {
    public boolean increasingTriplet(int[] nums) {
        //left[i] will have min to the left of i in nums
        //right[i] will have max to the right of i in nums

        int[] left = new int[nums.length];
        int[] right = new int[nums.length];

        int min = nums[0];
        for(int i = 0; i < nums.length; i++)
        {
            min = Math.min(min, nums[i]);
            left[i] = min;
        }

        int max = nums[nums.length - 1];
        for(int i = nums.length - 1; i >= 0; i--)
        {
            max = Math.max(max, nums[i]);
            right[i] = max;
        }

        for(int i = 0; i < nums.length; i++)
        {
            if(left[i] < nums[i] && nums[i] < right[i])
            {
                //good
                return true;
            }
        }
        return false;
    }
}

//find first incr

//keep running m