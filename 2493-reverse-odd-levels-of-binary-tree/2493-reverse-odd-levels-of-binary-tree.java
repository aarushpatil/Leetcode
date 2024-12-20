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
    public TreeNode reverseOddLevels(TreeNode root) {
        Queue<TreeNode> q = new LinkedList<TreeNode>();
        q.add(root);

        boolean oddLevel = true;
        while(!q.isEmpty())
        {
            oddLevel = !oddLevel;
            int size = q.size();
            TreeNode[] arr = new TreeNode[size];
            for(int i = 0; i < size; i++)
            {
                TreeNode curr = q.poll();
                if(curr == null)
                {
                    oddLevel = false;
                    break;
                }
                q.add(curr.left);
                q.add(curr.right);
                arr[i] = curr;
            }
            for(int i = 0; oddLevel && i < size / 2; i++)
            {
                int temp = arr[i].val;
                arr[i].val = arr[size - 1 - i].val;
                arr[size - 1 - i].val = temp;
            }
        }

        return root;
    }
}