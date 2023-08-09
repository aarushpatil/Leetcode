class Solution {
    public int search(int[] nums, int target) {

        if(nums.length == 1)
        {
            return nums[0] == target ? 0 : -1;
        }

        int left = 0;
        int right = nums.length - 1;

        int pivot = -1;
        if(nums[left] < nums[right])
        {
            pivot = 0;
        }
        while(pivot == -1)
        {
            int mid = (left + right)/2;
            if(nums[mid] > nums[mid + 1])
            {
                pivot = mid;
                break;
            }

            else if(nums[mid] > nums[left])
            {
                left = mid + 1;
            }
                
            else
            {
                right = mid;
            }
        }
        // return pivot;
        int res = binSearch(nums, target, 0, pivot);
        if(res != -1)
        {
            return res;
        }
        return binSearch(nums, target, pivot+1, nums.length - 1);

    }
    private static int binSearch(int[] nums, int target, int left, int right)
    {
        while(left <= right)
        {
            int mid = (left + right) / 2;
            if(nums[mid] == target)
            {
                return mid;
            }
            if(nums[mid] > target)
            {
                right = mid - 1;
            }
            else
            {
                left = mid + 1;
            }
        }
        return -1;
    }
}