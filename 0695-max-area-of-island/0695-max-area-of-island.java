class Solution {
    boolean[][] seen;
    int max;
    public int maxAreaOfIsland(int[][] grid) {
        seen = new boolean[grid.length][grid[0].length];
        max = 0;
        for(int i = 0; i < grid.length; i++)
        {
            for(int k = 0; k < grid[0].length; k++)
            {
                if(grid[i][k] == 1)
                {
                    //call
                    max = Math.max(max, recur(grid, i, k));

                }
            }
        }
        return max;
    }
    
    private int recur(int[][] grid, int r, int c) {
        // Base cases
        if (r < 0 || r >= grid.length || c < 0 || c >= grid[0].length || grid[r][c] == 0 || seen[r][c])    {
            return 0;
        }
        seen[r][c] = true;
        int area = 1;
        area += recur(grid, r + 1, c);
        area += recur(grid, r - 1, c);
        area += recur(grid, r, c + 1);
        area += recur(grid, r, c - 1);
        return area;
    }

}