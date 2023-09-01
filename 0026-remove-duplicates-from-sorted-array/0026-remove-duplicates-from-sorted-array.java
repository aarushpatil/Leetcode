class Solution {
    public int removeDuplicates(int[] nums) {
        int l = 0;
        int r = 0;
        int count = 0;

        while(r < nums.length - 1)
        {
            if(l == r)
            {
                r++;
            }
            else if(nums[l] != nums[r])
            {
                l++;
            }
            else if(nums[r + 1] != nums[l])
            {
                //delete nums[l]
                nums[l] = -101;
                count++;
                l++;
            }
            else
            {
                r++;
            }
        }

        //remove the last few repeating numbers
        if(nums[l] == nums[r])
        {
            while(l < nums.length - 1)
            {
                nums[l] = -101;
                count++;
                l++;
            }
        }

        //shift all the values over to the left
        l = 0;
        r = 0;
        while(r < nums.length)
        {
            if(nums[r] != -101)
            {
                nums[l] = nums[r];
                l++;
                r++;
            }
            else
            {
                r++;
            }
        }

        return nums.length - count;
    }
}