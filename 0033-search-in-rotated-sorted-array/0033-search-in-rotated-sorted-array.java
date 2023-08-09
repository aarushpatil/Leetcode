class Solution {
    public int search(int[] nums, int target) {

        if(nums.length == 1)
        {
            return (nums[0] == target) ? 0:-1;
        }
        //find pivot point using bin search.
		int left = 0;
		int right = nums.length - 1;
		int pivot = -1;
		if(nums[0] < nums[nums.length-1])
		{
			pivot = 0;
		}
		while(pivot == -1)
		{
			int mid = (left + right)/2;
            if(nums[mid] == target)
			{
				return mid;
			}
			if(nums[mid] > nums[mid + 1])
			{
				pivot = mid;
				break;
			}
			else
			{
				if(nums[left] < nums[mid])
				{
					left = mid + 1;
				}
				else
				{
					right = mid;
				}
			}
		}
		
		left = 0;
		right = pivot;
		return Math.max(binSearchHelper(left, right, target, nums), binSearchHelper(pivot + 1, nums.length - 1, target, nums));
    }

    private static int binSearchHelper(int left, int right, int target, int[] nums)
	{
		
		//binary search
		while(left <= right)
		{
			int mid = (left + right)/2;
			if(target == nums[mid])
			{
				return mid;
			}
			else if(target > nums[mid])
			{
				left = mid + 1;
			}
			else
			{
				right = mid - 1;
			}
		}
		
		return -1;
	}
}