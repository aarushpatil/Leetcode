class Solution {
    public int[] searchRange(int[] nums, int target) {
        //bin search through till I find nums

        int l = 0;
		int r = nums.length - 1;
		int found = -1;	
		
		while (l <= r) {
			int mid = (l + r) / 2;
			if (nums[mid] == target) {
				found = mid;
				break;
			}
			if (nums[mid] < target) {
				l = mid + 1;
			} else {
				r = mid - 1;
			}
		}
		if(found == -1)
		{
			return new int[] {-1,-1};
		}

        if(nums[l] != target)
        {
            //find beginning and end of target value using found.
            int r2 = found;
            while(l <= r2)
            {
                int mid = (l+r2) / 2;
                if(nums[mid] == target)
                {
                    r2 = mid;
                }

                else if(nums[mid] < target)
                {
                    l = mid + 1;
                }

                if(nums[l] == target)
                {
                    break;
                }
            }
        }

        if(nums[r] == target)
        {
            return new int[]{l, r};
        }

        int l2 = found;
        while(l2 <= r)
        {
            int mid = (l2 + r)/2;

            if(nums[mid] == target)
            {
                l2 = mid + 1;
            }

            else if(nums[mid] > target)
            {
                r = mid - 1;
            }

            if(nums[r] == target)
            {
                return new int[]{l, r};
            }
        }
        return new int[]{-1,-1};
    }
}