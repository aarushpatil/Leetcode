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
    public int pathSum(TreeNode root, int targetSum) {
        LinkedList<Long> list = new LinkedList<>();
        // list.add();
        dfs(root, list, targetSum);

        return ans;
    }

    int ans = 0;
    void dfs(TreeNode rt, LinkedList<Long> sums, int targetSum)
    {
        // System.out.println(sums.toString());
        if(rt == null)
        {
            return;
        }

        LinkedList<Long> newList = new LinkedList<>();
        for(long sum : sums)
        {
            long val = sum + rt.val;
            if(val == targetSum)
            {
                ans++;
            }
            newList.add(val);
        }
        newList.add((long)rt.val);
        if(rt.val == targetSum)
        {
            ans++;
        }

        dfs(rt.left, newList, targetSum);
        dfs(rt.right, newList, targetSum);
    }
}