class Solution {
    public int searchInsert(int[] nums, int target) {
        int l = 0;
        int r = nums.length - 1;
        int mid = 0;

        //binary search
        while(l <= r)
        { 
            mid = (l + r) / 2;
            //target is on the left of mid
            if(target < nums[mid])
            {
                r = mid - 1;
            }
            //target is on the right of mid
            else if(target > nums[mid])
            {
                l = mid + 1;
            }
            //target is equal to mid
            else
            {
                return mid;
            }
        }

        //target not found, find index where target should be
        if(nums[mid] < target)
        {
            return mid + 1;
        }
        return mid;
    }
}