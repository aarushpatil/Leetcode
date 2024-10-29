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
        Queue<Integer> qLevel = new LinkedList<>();
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        qLevel.add(1);
        HashMap<Integer, Long> sizes = new HashMap<>();

        while(!q.isEmpty())
        {
            TreeNode curr = q.poll();
            int level = qLevel.poll();
            if(curr == null) continue;

            // sizes[level] += curr.val;
            sizes.put(level, sizes.getOrDefault(level, (long)0) + curr.val);

            q.add(curr.left);
            q.add(curr.right);
            qLevel.add(level + 1);
            qLevel.add(level + 1);
        }

        long maxSize = Integer.MIN_VALUE;
        int maxInd = 0;
        for(Map.Entry<Integer, Long> e : sizes.entrySet())
        {
            int i = e.getKey();
            long v = e.getValue();
            if(v > maxSize)
            {
                maxInd = i;
                maxSize = v;
            }
        }

        System.out.println(sizes.toString());
        return maxInd;
    }
}