class Solution {
    int[][] matrix;
    boolean[] visited;
    
    public int findCircleNum(int[][] isConnected) {
        int n = isConnected.length;
        matrix = isConnected;
        visited = new boolean[n];
        int numProvinces = 0;

        for(int x = 0; x < n; x++) {
            if(!visited[x]) {
                numProvinces++;
                dfs(x);
            }
        }

        return numProvinces;
    }

    public void dfs(int current) {
        if (visited[current]) return;
        
        visited[current] = true;

        for (int i = 0; i < matrix[current].length; i++) {
            // if (matrix[current][i] == 0) continue;
            // dfs(matrix[current][i]);

            if (matrix[current][i] == 1 && !visited[i]) { 
            dfs(i);
        }
        }
        
    }
}