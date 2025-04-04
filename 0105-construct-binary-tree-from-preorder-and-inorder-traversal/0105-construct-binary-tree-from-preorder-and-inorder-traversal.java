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
    HashMap<Integer, Integer> map;
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        map = new HashMap();
        for(int i = 0; i < inorder.length; i++)
        {
            map.put(inorder[i], i);
        }

        LinkedList<TreeNode> st = new LinkedList();
        TreeNode rt = new TreeNode(preorder[0]);
        st.addFirst(rt);

        for(int i = 1; i < preorder.length; i++)
        {
            int curr = preorder[i];
            
            //place it
            if(isLeft(curr, st.getFirst().val)) //to left of st.peek
            {
                TreeNode tmp = new TreeNode(curr);
                st.getFirst().left = tmp;
                st.addFirst(tmp);
            }
            else
            {
                while(st.size() > 1 && !isLeft(curr, st.get(1).val))
                {
                    st.removeFirst();
                }

                //add to right of peek
                TreeNode tmp = new TreeNode(curr);
                st.getFirst().right = tmp;
                
                st.removeFirst();
                st.addFirst(tmp);
            }
        }

        return rt;
    }


    //a is left of b
    boolean isLeft(int a, int b)
    {
        return map.get(a) < map.get(b);
    }
}
