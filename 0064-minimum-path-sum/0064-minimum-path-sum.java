class Solution {
    public int minPathSum(int[][] grid) {
        int rows = grid.length;
        int cols = grid[0].length;
        int[][] dist = new int[rows][cols];

        for (int[] row : dist) {
            Arrays.fill(row, Integer.MAX_VALUE);
        }

        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(a -> dist[a[0]][a[1]]));
        pq.add(new int[]{0, 0});
        dist[0][0] = grid[0][0];

        int[][] directions = {{1, 0}, {0, 1}};

        while (!pq.isEmpty()) {
            int[] curr = pq.poll();
            int currRow = curr[0];
            int currCol = curr[1];

            for (int[] dir : directions) {
                int newRow = currRow + dir[0];
                int newCol = currCol + dir[1];

                if (newRow < rows && newCol < cols) {
                    int newDist = dist[currRow][currCol] + grid[newRow][newCol];
                    if (newDist < dist[newRow][newCol]) {
                        dist[newRow][newCol] = newDist;
                        pq.add(new int[]{newRow, newCol});
                    }
                }
            }
        }

        return dist[rows - 1][cols - 1];
    }
}