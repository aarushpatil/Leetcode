class Solution {
    char[][] mat;
    boolean[][] visited;
    public int numIslands(char[][] grid) {
        mat = grid;
        visited = new boolean[grid.length][grid[0].length];
        
        int ans = 0;
        for(int i = 0; i < grid.length; i++)
        {
            for(int k = 0; k < grid[i].length; k++)
            {
                if(grid[i][k] == '1' && !visited[i][k])
                {
                    System.out.println("entered on " + i + " " + k);
                    ans++;
                    bfs(new int[]{i, k});
                }
            }
        }

        return ans;
    }

    void bfs(int[] start)
    {
        int row = start[0];
        int col = start[1];

        Queue<int[]> q = new LinkedList<>();
        q.add(start);

        int[] neighbors = {1,0, 0,1, -1,0, 0,-1};

        while(!q.isEmpty())
        {
            int[] curr = q.poll();
            int x = curr[0];
            int y = curr[1];
            
            //check in bounds, and check it is a 1
            boolean inBounds = x >= 0 && y >= 0 && x < mat.length && y < mat[x].length;
            if(!inBounds || mat[x][y] != '1' || visited[x][y])
            {
                continue;
            }

            visited[x][y] = true;
            for(int i = 0; i < neighbors.length; i+=2)
            {
                q.add(new int[]{neighbors[i] + x, neighbors[i+1] + y});
            }
        }
    }
}