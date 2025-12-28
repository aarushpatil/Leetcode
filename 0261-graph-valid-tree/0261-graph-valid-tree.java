class Solution {
    public boolean validTree(int n, int[][] edges) {

        // if(edges.length == 0 && n > 1) return false;
        visited = new boolean[n];
        //no loops
        //# of edges is num nodes - 1

        //make adj list
        HashMap<Integer, List<Integer>> adjList = new HashMap<>();
        for(int i = 0; i < edges.length; i++)
        {
            int from = edges[i][0];
            int to = edges[i][1];

            List<Integer> neighbors = adjList.getOrDefault(from, new LinkedList());
            neighbors.add(to);
            adjList.put(from, neighbors);

            neighbors = adjList.getOrDefault(to, new LinkedList());
            neighbors.add(from);
            adjList.put(to, neighbors);
        }

        dfs(0, -1, adjList);

        if(loop) return false;

        return n == numNodes;
    }

    int numNodes = 0;
    boolean[] visited;
    boolean loop = false;

    //visited: 0, 

    void dfs(int curr, int prev, HashMap<Integer, List<Integer>> adjList)
    {
        if(loop) return;
        visited[curr] = true;
        numNodes++;

        List<Integer> neighbors = adjList.getOrDefault(curr, new LinkedList<>());
        for(int neighbor : neighbors)
        {
            if(neighbor == prev) continue;

            if(visited[neighbor])
            {
                loop = true;
                return;
            }
            dfs(neighbor, curr, adjList);
        }
    }
}