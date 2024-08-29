class Solution {
    public int minSubArrayLen(int target, int[] nums) {
        //open: sum < target
        //close: sum > target
        //track min size
        //size = r - l

        int s = 0;
        for(int i : nums)
        {
            s += i;
        }

        if(s < target) return 0;

        int l = 0;
        int r = 0;
        int sum = nums[0];

        int min = nums.length;

        while(r != nums.length - 1 || l != nums.length - 1)
        {
            System.out.println("sum: " + sum + " bounds: " + l + " - " + r);
            if(sum < target && r < nums.length - 1)
            {
                r++;
                sum += nums[r];
            }
            else if(sum >= target)
            {
                //record min
                min = Math.min(min, r - l + 1);
                // System.out.println(min + ": " + l + " - " + r);
                sum -= nums[l];
                l++;
            }

            else if(r == nums.length - 1 && sum - nums[l] < target)
            {
                // System.out.println("break: " + l + " - " + r);
                break;
            }
        }

        if(nums[nums.length - 1] >= target)
        {
            min = 1;
        }

        return min;
    }
}