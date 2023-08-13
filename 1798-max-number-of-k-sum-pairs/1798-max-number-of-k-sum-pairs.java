class Solution {
    public int maxOperations(int[] nums, int k) {
        //O(nlogn)
        int counter = 0;
        int left = 0;
        int right = nums.length - 1;

        Arrays.sort(nums);
        while(left < right)
        {
            if(nums[left] + nums[right] == k)
            {
                counter++;
                left++;
                right--;
            }
            else if(nums[left] + nums[right] < k)
            {
                left++;
            }
            else
            {
                right--;
            }
        }
        return counter;
    }
}