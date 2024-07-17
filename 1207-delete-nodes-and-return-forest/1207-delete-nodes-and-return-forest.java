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
    HashSet<Integer> del;
    List<TreeNode> ret;
    TreeNode fly;
    public List<TreeNode> delNodes(TreeNode root, int[] to_delete) {
        del = new HashSet<>();
        ret = new ArrayList<>();
        fly = new TreeNode(0);
        for(int num : to_delete)
        {
            del.add(num);
        }

        if(!del.contains(root.val))
        {
            ret.add(root);
        }

        recur(root);
        
        for(int i = 0; i < ret.size(); i++)
        {
            remFly(ret.get(i));
            
        }

        for(int i = 0; i < ret.size(); i++)
        {
            if(del.contains(ret.get(i).val))
            {
                ret.remove(i);
                i--;
            }
        }

        return ret;
    }

    void remFly(TreeNode rt)
    {
        if(rt == null)
        {
            return;
        }

        if(rt.left != null && del.contains(rt.left.val))
        {
            rt.left = null;
        }
        if(rt.right != null && del.contains(rt.right.val))
        {
            rt.right = null;
        }

        remFly(rt.left);
        remFly(rt.right);
    }

    void recur(TreeNode rt)
    {
        if(rt == null) return;

        if(del.contains(rt.val))
        {
            if(rt.left != null)
            {
                ret.add(rt.left);
            }
            if(rt.right != null)
            {
                ret.add(rt.right);
            }
        }

        recur(rt.left);
        recur(rt.right);
    }

}