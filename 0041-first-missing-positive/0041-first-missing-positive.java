class Solution {
    public int firstMissingPositive(int[] nums) {
//remove everything with negatives and any numbers greater than nums.length

//[3,4,-1,1]
//[3,4,0,0]
        HashSet<Integer> set = new HashSet<>();
        for(int i = 0; i < nums.length; i++)
        {
            if(nums[i] > 0)
            {
                set.add(nums[i]);
            }
        }

        for(int i = 1; i < nums.length + 2; i++)
        {
            if(!set.contains(i))
            {
                return i;
            }
        }
        return 0;
    }
}