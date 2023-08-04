/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public boolean hasCycle(ListNode head) {

        HashSet<ListNode> set = new HashSet<ListNode>();
        ListNode curr = head;
        while(curr != null)
        {
            //if it's already in the set it won't be able to add and it will enter if statement
            if(!set.add(curr))
            {
                return true;
            }
            curr = curr.next;
        }
        return false;
    }

}