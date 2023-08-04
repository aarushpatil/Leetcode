class Solution {
    public int longestConsecutive(int[] nums) {

        //Good solution, O(n) time.
        //Utilizes set

        //for [] edge case
        if(nums.length == 0)
        {
            return 0;
        }

        HashSet<Integer> set = new HashSet<Integer>();
        for(int i = 0; i < nums.length; i++)
        {
            set.add(nums[i]);
        }

        int max = Integer.MIN_VALUE;
        for(int i = 0; i < nums.length; i++)
        {
            if(!set.contains(nums[i] - 1))
            {
                int counter = 0;
                int temp = nums[i];
                //potential start of a consecutive elements sequence
                while(set.contains(temp + 1))
                {
                    temp++;
                    counter++;
                }
                max = Math.max(max, counter);
            }
        }
        return max + 1;























        // if(nums.length == 0)
        // {
        //     return 0;
        // }


        //brute force: O(nlogn) time
        // Arrays.sort(nums);

        // int counter = 1;
        // int max = 1;
        // for(int i = 0; i < nums.length-1; i++)
        // {
        //     System.out.print(nums[i] + ", ");
        //     if(nums[i] + 1 == nums[i+1])
        //     {
        //         counter++;
        //         max = Math.max(max, counter);
        //     }
        //     else if(nums[i] != nums[i+1])
        //     {
        //         counter = 1;
        //     }
        // }
        // return max;

    }
}