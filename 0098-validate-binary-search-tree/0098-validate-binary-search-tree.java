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
    public boolean isValidBST(TreeNode root) {
        return solve(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }

    public boolean solve(TreeNode rt, long minBound, long maxBound)
    {
        if(rt == null)
        {
            return true;
        }

        if(rt.val <= minBound || rt.val >= maxBound)
        {
            return false;
        }

        return solve(rt.left, minBound, rt.val) && solve(rt.right, rt.val, maxBound);
    }
}