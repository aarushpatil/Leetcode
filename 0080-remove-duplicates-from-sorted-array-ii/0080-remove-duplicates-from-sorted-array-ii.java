class Solution {
    public int removeDuplicates(int[] nums) {

        int min = Integer.MIN_VALUE;

        boolean same = true;
        int value = nums[0];
        for(int i = 0; i < nums.length; i++)
        {
            if(value != nums[i])
            {
                same = false;
            }
        }
        if(same) return 2;

        // Arrays.sort(nums);
        for(int i = 2; i < nums.length; i++)
        {
            if(nums[i - 2] == nums[i - 1])
            {
                int val = nums[i - 2];
                while(i < nums.length && nums[i] == val)
                {
                    //rmeove
                    nums[i] = min;
                    i++;
                }
            }
        }

        int count = 0;
        int emptyPtr = -1;
        for(int i = 0; i < nums.length; i++)
        {
            if(emptyPtr == -1 && nums[i] == min)
            {
                //init empty
                emptyPtr = i;
            }

            if(nums[i] != min)
            {
                count++;
            }
            
            if(nums[i] != min && emptyPtr != -1) //need to move back 
            {
                nums[emptyPtr] = nums[i];
                nums[i] = min;
                //find next empty
                while(emptyPtr < nums.length && nums[emptyPtr] != min)
                {
                    emptyPtr++;
                }
            }
        }

        return count;
    }
}