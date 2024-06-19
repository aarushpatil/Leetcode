class Solution {
    public int findPeakElement(int[] nums) {
        int left = 0;
        int right = nums.length - 1;

        if(nums.length == 1)
        {
            return 0;
        }


        if(nums.length == 2)
        {
            if(nums[0] > nums[1])
            {
                return 0;
            }
            return 1;
        }

        

        while(left <= right)
        {
            int mid = (left + right) / 2;
            if(mid == 0)
            {
                if(nums[mid] > nums[mid + 1]) return mid;
                return mid+1;
            }
            if(mid == nums.length-1)
            {
                if(nums[mid] > nums[mid -1]) return mid;
                return mid-1;
            }

            if(nums[mid] < nums[mid+1] && nums[mid-1] < nums[mid]) //incr
            {
                left = mid + 1;
            }

            else if(nums[mid - 1] < nums[mid] && nums[mid] > nums[mid + 1]) //answer
            {
                return mid;
            }

            // else if(nums[mid - 1] > nums[mid] && nums[mid] < nums[mid + 1]) //bottom peak case...
            // {
            //     //weird case
            //     System.out.println("helpp");
            //     break;
            // }

            else    // decr
            {
                right = mid - 1;
            }
        }
        return 0;
    }
}