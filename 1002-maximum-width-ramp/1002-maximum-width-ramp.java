class Solution {
    public int maxWidthRamp(int[] nums) {
        
        int[] right = new int[nums.length];
        right[nums.length-1] = nums[nums.length - 1];
        for(int i = nums.length - 2; i >= 0; i--)
        {
            right[i] = Math.max(right[i + 1], nums[i]);
        }
        System.out.println(Arrays.toString(right));


        int left = 0;
        int r = 0;

        int maxW = 0;
        while(r < nums.length)
        {
            if(left >= r || nums[left] <= right[r])
            {
                //yk that theres a bigger option
                r++;
            }
            else
            {
                left++;
            }
            maxW = Math.max(r-left-1, maxW);
        }

        return maxW;
    }
}

//9,1,7,6,3,0
//9,7,7,6,3,0
