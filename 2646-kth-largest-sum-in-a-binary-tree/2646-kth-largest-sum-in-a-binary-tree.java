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
    public long kthLargestLevelSum(TreeNode root, int k) {
        PriorityQueue<Long> pq = new PriorityQueue<>(Collections.reverseOrder());
        Queue<TreeNode> q = new LinkedList<>();

        ArrayList<Long> list = new ArrayList<>();

        q.add(root);
        while(!q.isEmpty()){
            int size = q.size();
            long currSum = 0;
            for(int i = 0 ; i < size ; i++){
                TreeNode curr = q.remove();
                currSum += curr.val;
                if(curr.left != null) q.add(curr.left);
                if(curr.right != null) q.add(curr.right);
            }
            list.add(currSum);
        } 
        pq.addAll(list);
        while(!pq.isEmpty() && k != 1){
            pq.remove();
            k--;
        }

        if(pq.isEmpty()) return -1;
        else return pq.remove();
    }
}