class Solution {
    public int longestConsecutive(int[] nums) {

        if(nums.length == 0)
        {
            return 0;
        }


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

        


        //Good solution, O(n) time.
        //Utilizes set
        
        HashSet<Integer> set = new HashSet<Integer>();
        for(int i = 0; i < nums.length; i++)
        {
            set.add(nums[i]);
        }

        int max = 0;
        int count = 0;
        for(int i = 0; i < nums.length; i++)
        {
            if(!set.contains(nums[i] - 1))
            {
                int temp = nums[i];
                while(set.contains(temp+1))
                {
                    temp++;
                    count++;
                }
                max = Math.max(max, count);
                count = 0;
            }
        }
        return max+1;
        

    }
}