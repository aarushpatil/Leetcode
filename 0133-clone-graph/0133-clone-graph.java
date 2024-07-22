/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> neighbors;
    public Node() {
        val = 0;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val) {
        val = _val;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val, ArrayList<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
}
*/

class Solution {
    Node[] theNodes;
    public Node cloneGraph(Node node) {
        theNodes = new Node[101];
        dfs(node);
        // setNeighbors(node);
        return theNodes[1];
    }

    void dfs(Node start)
    {
        if(start == null || theNodes[start.val] != null) return;
        theNodes[start.val] = new Node(start.val, (ArrayList<Node>)start.neighbors);
        System.out.println(start.val);
        for(Node neighbor : start.neighbors)
        {
            dfs(neighbor);
        }
        //can set neighbors right here

        List<Node> n = new ArrayList<>();
        for(Node neighbor : start.neighbors)
        {
            n.add(theNodes[neighbor.val]);
        }

        theNodes[start.val].neighbors = n;
    }

    // void setNeighbors(Node start)
    // {
    //     for(Node neighbor : start.neighbors)
    //     {
    //         dfs(neighbor);
    //     }
    //     List<Node> n = new ArrayList<>();
    //     for(Node neighbor : start.neighbors)
    //     {
    //         n.add(theNodes[neighbor.val]);
    //     }

    //     theNodes[start.val].neighbors = n;
    // }
}