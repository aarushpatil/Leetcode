class Solution {
    HashMap<Integer, LinkedList<Integer>> map;
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        map = new HashMap<>();
        visited = new int[numCourses];
        ans = new ArrayList<>();

        for(int i = 0; i < prerequisites.length; i++)
        {
            int from = prerequisites[i][0];
            int to = prerequisites[i][1];

            LinkedList<Integer> list = map.getOrDefault(from, new LinkedList<>());
            list.add(to);
            map.put(from, list);
        }

        for(int i = 0; i < numCourses; i++)
        {
            if(visited[i] == 0)
            {
                dfs(i);
                if(cycle) return new int[0];
            }
        }

        int[] out = new int[ans.size()];
        for(int i = 0; i < out.length; i++)
        {
            out[i] = ans.get(i);//ans.get(ans.size() - i - 1);
        }

        return out;
    }

    int[] visited;
    boolean cycle;
    ArrayList<Integer> ans;
    void dfs(int node)
    {
        if(visited[node] == 2 || cycle) return;
        if(visited[node] == 1) //found cycle
        {
            cycle = true;
            return;
        }

        visited[node] = 1; //in processing
        if(map.containsKey(node))
        {
            for(int neigh : map.get(node))
            {
                dfs(neigh);
            }
        }

        visited[node] = 2; //finished visiting
        ans.add(node);
    }
}