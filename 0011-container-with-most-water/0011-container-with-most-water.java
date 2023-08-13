class Solution {
    public int maxArea(int[] height) {
        //brute force
        // int maxArea = 0;
        // for(int i = 0; i < height.length; i++)
        // {
        //     for(int k = i; k < height.length; k++)
        //     {
        //         int water = Math.min(height[i], height[k]);
        //         maxArea = Math.max(maxArea, water * (k - i));
        //     }
        // }
        // return maxArea;


        //O(n)
        int l = 0;
        int r = height.length - 1;

        int maxArea = 0;
        while(l < r)
        {
            maxArea = Math.max(maxArea, (r - l) * Math.min(height[l], height[r]));
            if(height[l] < height[r])
            {
                l++;
            }
            else
            {
                r--;
            }
        }
        return maxArea;
    }
}