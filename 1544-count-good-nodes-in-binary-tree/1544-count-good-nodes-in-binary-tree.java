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
    public int goodNodes(TreeNode root) {
        dfs(root, -100000);
        return count;
    }

    int count = 0;
    void dfs(TreeNode rt, int maxSoFar)
    {
        if(rt == null)
        {
            return;
        }

        if(rt.val >= maxSoFar)
        {
            count++;
        }
        maxSoFar = Math.max(rt.val, maxSoFar);

        dfs(rt.left, maxSoFar);
        dfs(rt.right, maxSoFar);
    }
}