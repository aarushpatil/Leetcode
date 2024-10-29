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
class Solution {
    public int longestZigZag(TreeNode root) {
        // Queue<TreeNode> q = new LinkedList<>();
        // q.add(root);

        // while(!q.isEmpty())
        // {
        //     TreeNode curr = q.poll();
        //     if(curr == null) continue;

        //     dfs(curr, true, 0);
        //     dfs(curr, false, 0);
        //     q.add(root.left);
        //     q.add(root.right);
        // }


        dfs(root, true, 0);
        dfs(root, false, 0);
        return max;
    }

    int max = 0;
    void dfs(TreeNode rt, boolean b, int count)
    {
        if(rt == null) return;

        if(b)
        {
            dfs(rt.left, !b, count + 1);
            
            // dfs(rt.right, b, 0);
            dfs(rt.right, !b, 0);
        }
        else
        {
            dfs(rt.right, !b, count + 1);

            // dfs(rt.left, b, 0);
            dfs(rt.left, !b, 0);
        }
        max = Math.max(count, max);
    }
}