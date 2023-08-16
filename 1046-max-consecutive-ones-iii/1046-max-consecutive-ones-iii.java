class Solution {
    public int longestOnes(int[] nums, int k) {
        
        //brute force

        // int max = 0;//2
        // int next0 = 0;
        // boolean found0 = false;
        // int currCount = 0;//2
        // int zeroCount = 0;
        // int r = 0;//2
        // while(r < nums.length)
        // {
        //     if(nums[r] == 0)
        //     {
        //         //sets next0 to the next 0 index
        //         next0 = (found0) ? next0 : r;
        //         found0 = true;
                
        //         //flip the 0 if we can
        //         if(zeroCount == k)
        //         {
        //             //reset window at next0
        //             r = next0;
        //             found0 = false;
        //             zeroCount = 0;
        //             currCount = 0;
        //         }
        //         else
        //         {
        //             currCount++;
        //             zeroCount++;
        //         }

        //     }
        //     else
        //     {
        //         currCount++;
        //     }
        //     max = Math.max(max, currCount);
        //     r++;
        // }
        // return max;

        int max = 0;
        int l = 0;
        int r = 0;

        while(r < nums.length)
        {
            if(nums[r] == 0)
            {
                k--;
            }
            if(k < 0)
            {
                if(nums[l] == 0)
                {
                    k++;
                }
                l++;
            }
            r++;
            max = Math.max(max, r - l);
        }
        return max;

    }
}