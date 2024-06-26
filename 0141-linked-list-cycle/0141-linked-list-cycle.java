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
        ListNode two = head;
        // ListNode curr = head;
        while(two != null && head != null)
        {
            head = head.next;
            two = two.next;
            if(two != null)
            {
                two = two.next;
                if(head == two)
                {
                    return true;
                }
            }
            else
            {
                return false;
            }
        }

        return false;
    }
}