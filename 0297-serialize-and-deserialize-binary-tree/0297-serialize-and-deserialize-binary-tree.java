/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */

public class Codec {

    // Encodes a tree to a single string.

    TreeNode flyweight = new TreeNode(-1); //represents null
    public String serialize(TreeNode root) {
        if(root == null) return "";

        Queue<TreeNode> queue = new LinkedList();
        queue.add(root);

        StringBuilder output = new StringBuilder();
        while(!queue.isEmpty())
        {
            TreeNode curr = queue.poll();
            //add to output
            output.append(",");
            if(curr == flyweight)
            {
                output.append("null");
                continue;
            }
            output.append(curr.val);


            //add children
            if(curr.left == null) 
                queue.add(flyweight);
            else 
                queue.add(curr.left);


            if(curr.right == null) 
                queue.add(flyweight);
            else 
                queue.add(curr.right);
        }

        String str = output.toString();

        return str.substring(1);
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if(data.length() == 0) return null; //edge case

        String[] arr = data.split(",");
        TreeNode root = makeNode(arr[0]);

        Queue<TreeNode> q = new LinkedList();
        q.add(root);
        for(int i = 1; i < arr.length; i += 2)
        {
            TreeNode curr = q.poll();
            TreeNode left = makeNode(arr[i]);
            TreeNode right = makeNode(arr[i + 1]);
            curr.left = left;
            curr.right = right;

            if(left != null)
                q.add(left);
            
            if(right != null)
                q.add(right);
        }
        return root;
    }

    TreeNode makeNode(String val)
    {
        if(val.equals("null"))
        {
            return null;
        }

        return new TreeNode(Integer.parseInt(val));
    }
}
