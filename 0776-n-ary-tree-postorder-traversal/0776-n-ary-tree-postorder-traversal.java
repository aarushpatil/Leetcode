/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> children;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, List<Node> _children) {
        val = _val;
        children = _children;
    }
};
*/

class Solution {
    public List<Integer> postorder(Node root) {

        return post(root, new ArrayList<>());
        // return list;
    }

    List<Integer> post(Node root, List<Integer> list) 
    {
        if(root == null) 
        {
            return new ArrayList<>();
        }

        for(Node n : root.children) 
        {
            post(n, list);
        }

        list.add(root.val);
        return list;
    }
}