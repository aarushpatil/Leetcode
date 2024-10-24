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
        Queue<Integer> levelQ = new LinkedList<Integer>();
        Queue<TreeNode> q = new LinkedList<>();

        HashMap<Integer, Long> levelSum = new HashMap<>();
        // long[] levelSum = new long[100000];

        //key is level index
        //value is sum

        //bfs over tree
        q.add(root);
        levelQ.add(0);

        while(!q.isEmpty())
        {
            TreeNode currNode = q.poll();
            int currLevel = levelQ.poll();
            if(currNode == null) continue;

            // levelSum[currLevel] += currNode.val;
            levelSum.put(currLevel, levelSum.getOrDefault(currLevel, (long)0) + currNode.val);

            levelQ.add(currLevel + 1);
            q.add(currNode.left);

            levelQ.add(currLevel + 1);
            q.add(currNode.right);
        }

        // System.out.println(Arrays.toString(levelSum));

        ArrayList<Long> nums = new ArrayList<>();
        for(long n : levelSum.values())
        {
            if(n == 0)
            {
                break;
            }
            nums.add(n);
        }

        System.out.println(nums);
        if(k > nums.size())
        {
            return -1;
        }

        PriorityQueue<Long> priQueue = new PriorityQueue<>(Collections.reverseOrder());
        priQueue.addAll(nums);

        for(int i = 0; i < k-1; i++)
        {
            priQueue.poll();
        }

        return priQueue.poll();


        // Arrays.sort(levelSum);
    }
}