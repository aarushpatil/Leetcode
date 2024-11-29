class Solution {
    int[][] mat;
    boolean[][] visited;
    public int minimumTime(int[][] grid) {

        if(grid[0][1] > 1 && grid[1][0] > 1)
        {
            return -1;
        }
        
        visited = new boolean[grid.length][grid[0].length];
        mat = grid;
        PriorityQueue<int[]> q = new PriorityQueue<>((a, b) -> a[0] - b[0]);
        q.add(new int[]{0, 0, 0});
        while(!q.isEmpty())
        {
            int[] curr = q.poll();
            int time = curr[0];
            int x = curr[1];
            int y = curr[2];
            if(visited[x][y]) continue;
            
            visited[x][y] = true;

            System.out.println(time  + " : " + x + " " + y);

            if(x == grid.length - 1 && y == grid[0].length - 1)
            {
                return time;
            }


            if(isValid(x + 1, y))
            {
                int newTime = grid[x+1][y];
                int t = Math.max(time + 1, (time - newTime) % 2 == 0 ? newTime + 1 : newTime);
                q.add(new int[]{t, x+1, y});
            }
            if(isValid(x, y + 1))
            {
                int newTime = grid[x][y + 1];
                int t = Math.max(time + 1, (time - newTime) % 2 == 0 ? newTime + 1 : newTime);
                q.add(new int[]{t, x, y + 1});
            }

            if(isValid(x - 1, y))
            {
                int newTime = grid[x - 1][y];
                int t = Math.max(time + 1, (time - newTime) % 2 == 0 ? newTime + 1 : newTime);
                q.add(new int[]{t, x - 1, y});
            }

            if(isValid(x, y - 1))
            {
                int newTime = grid[x][y - 1];
                int t = Math.max(time + 1, (time - newTime) % 2 == 0 ? newTime + 1 : newTime);
                q.add(new int[]{t, x, y - 1});
            }
        }

        return -1;
    }

    boolean isValid(int x, int y)
    {
        if(x < mat.length && y < mat[0].length && x >= 0 && y >= 0 && !visited[x][y])
        {
            return true;
        }
        return false;
    }
}

