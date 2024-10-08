class Solution {

    HashMap<Integer, ArrayList<Integer>> graph;
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        //just have to check if there is a cycle

        graph = new HashMap<>();
        visited = new int[numCourses + 1];
        cycle = false;

        for(int i = 0; i < numCourses; i++)
        {
            graph.put(i, new ArrayList<>());
        }
        
        for(int i = 0; i < prerequisites.length; i++)
        {
            int key = prerequisites[i][0];
            int val = prerequisites[i][1];

            ArrayList<Integer> list = graph.get(key);
            list.add(val);
            graph.put(key, list);
        }

        for(int i = 0; i < numCourses; i++)
        {
            // System.out.println(i);
            if(visited[i] != 2)
            {
                dfs(i);
            }
            if(cycle) return false;
        }
        return true;
    }

    boolean cycle;
    int[] visited;
    void dfs(int node)
    {
        if (visited[node] == 2) return; 
        if(visited[node] == 1 || cycle) 
        {
            cycle = true; 
            return;
        }
        
        visited[node] = 1;
        for(int i = 0; i < graph.get(node).size(); i++)
        {
            dfs(graph.get(node).get(i));
        }
        visited[node] = 2;
    }
}

// 3->1->4
//  \   /
//    2

