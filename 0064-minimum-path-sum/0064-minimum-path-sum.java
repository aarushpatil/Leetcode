class Solution {
    int min;
    public int minPathSum(int[][] grid) {
        min = Integer.MAX_VALUE;
        travel(0, 0, grid[0][0], grid);
        return min;
    }
    void travel(int x, int y, int sum, int[][] grid)
    {
        if(x == grid[0].length - 1 && y == grid.length - 1)
        {
            min = Math.min(sum, min);
        }
        //go right
        if(x + 1 < grid[0].length)
        {
            travel(x+1, y, sum + grid[y][x+1], grid);
        }
        //go down
        if(y + 1 < grid.length)
        {
            travel(x, y+1, sum + grid[y+1][x], grid);
        }
    }
}