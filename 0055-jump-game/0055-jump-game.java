class Solution {
    public boolean canJump(int[] nums) {
        boolean[] arr = new boolean[nums.length];
        arr[0] = true;
        for(int i = 0; i < nums.length - 1; i++)
        {
            if(arr[i])
            {
                for(int k = 0; k < nums[i]; k++)
                {
                    if(i + k + 1 < arr.length)
                    {
                        arr[i + k + 1] = true;
                    }
                }
            }
            System.out.println("\n\n");
        }
        System.out.println(Arrays.toString(arr));
        return arr[nums.length - 1];
    }
}