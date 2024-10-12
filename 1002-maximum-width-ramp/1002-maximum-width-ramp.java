class Solution {
    public int maxWidthRamp(int[] nums) {
        
        // int[] right = new int[nums.length];
        // right[nums.length-1] = nums[nums.length - 1];
        // for(int i = nums.length - 2; i >= 0; i--)
        // {
        //     right[i] = Math.max(right[i + 1], nums[i]);
        // }
        // System.out.println(Arrays.toString(right));


        // int left = 0;
        // int r = 0;

        // int maxW = 0;
        // while(r < nums.length)
        // {
        //     if(left >= r || nums[left] <= right[r])
        //     {
        //         //yk that theres a bigger option
        //         r++;
        //     }
        //     else
        //     {
        //         left++;
        //     }
        //     maxW = Math.max(r-left-1, maxW);
        // }

        // return maxW;


        List<Integer> list = new LinkedList<>();

        list.addFirst(0);

        for(int i = 1; i < nums.length; i++)
        {
            if(nums[list.get(0)] > nums[i])
            {
                list.addFirst(i);
            }
        }

        int maxW = 0;
        for(int i = nums.length - 1; i >= 0 && list.size() > 0; i--)
        {
            while(list.size() > 0 && nums[i] >= nums[list.get(0)]) //make this a while
            {
                maxW = Math.max(maxW, i - list.get(0));
                list.removeFirst();
            }
        }

        return maxW;

    }
}

//9,1,7,6,3,0
//9,7,7,6,3,0
