class Solution {
    public int maxIncreaseKeepingSkyline(int[][] grid) {
        int[] horiz = new int[grid.length];
        int[] vert = new int[grid.length];

        int n = grid.length;
        for(int i = 0; i < n; i++)
        {
            int max = grid[i][0];
            for(int r = 0; r < n; r++)
            {
                max = Math.max(max, grid[i][r]);
            }
            vert[i] = max;
        }


        for(int i = 0; i < n; i++)
        {
            int max = grid[0][i];
            for(int r = 0; r < n; r++)
            {
                max = Math.max(max, grid[r][i]);
            }
            horiz[i] = max;
        }


        System.out.println(Arrays.toString(vert));
        System.out.println(Arrays.toString(horiz));

        
        int ans = 0;
        for(int i = 0; i < n; i++)
        {
            for(int k = 0; k < n; k++)
            {
                ans += (Math.min(vert[k], horiz[i]) - grid[i][k]);
            }
        }

        return ans;
    }
}