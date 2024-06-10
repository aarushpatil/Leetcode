/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public void deleteNode(ListNode node) {
        ListNode curr = node;
        // curr.val = curr.next.val;
        // curr = curr.next;
        while(curr.next.next != null)
        {
            curr.val = curr.next.val;
            curr = curr.next;
        }

        curr.val = curr.next.val;
        curr.next = null;
    }
}