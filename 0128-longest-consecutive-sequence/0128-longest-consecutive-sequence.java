class Solution {
    public int longestConsecutive(int[] nums) {

        if(nums.length == 0)
        {
            return 0;
        }


        //brute force:
        Arrays.sort(nums);

        int counter = 1;
        int max = 1;
        for(int i = 0; i < nums.length-1; i++)
        {
            System.out.print(nums[i] + ", ");
            if(nums[i] + 1 == nums[i+1])
            {
                counter++;
                max = Math.max(max, counter);
            }
            else if(nums[i] == nums[i+1])
            {
            
            }
            else
            {
                counter = 1;
            }
        }


        return max;



/*
        one for loop that runs through nums{

            
        }

*/
    }
}