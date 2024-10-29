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
    public int maxLevelSum(TreeNode root) {
        Queue<TreeNode> q = new LinkedList<>();

        int maxSize = Integer.MIN_VALUE;
        int maxInd = 0;

        q.add(root);

        int level = 1;
        while(!q.isEmpty())
        {
            int size = q.size();
            int sum = 0;
            for(int i = 0; i < size; i++)
            {
                TreeNode curr = q.poll();
                sum += curr.val;

                if(curr.left != null)
                {
                    q.add(curr.left);
                }
                if(curr.right != null)
                {
                    q.add(curr.right);
                }
            }

            if(sum > maxSize)
            {
                maxSize = sum;
                maxInd = level;
            }

            level++;
        }

        
        // for(Map.Entry<Integer, Integer> e : sizes.entrySet())
        // {
        //     int i = e.getKey();
        //     int v = e.getValue();
        //     if(v > maxSize)
        //     {
        //         maxInd = i;
        //         maxSize = v;
        //     }
        // }

        // System.out.println(sizes.toString());
        return maxInd;
    }
}