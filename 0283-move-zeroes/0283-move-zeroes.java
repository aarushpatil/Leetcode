class Solution {
    public void moveZeroes(int[] nums) {
        int p1 = 0;

        for(int i = 0; i < nums.length; i++)
        {
            if(nums[i] != 0)
            {
                nums[p1] = nums[i];
                p1++;
            }
        }

        for(int k=p1; k<nums.length; k++ )
        {
            nums[k] = 0;
        }
        // for(int i = nums.length - 1; i >= p1; i--)
        // {
        //     nums[i] = 0;
        // }

    }
}