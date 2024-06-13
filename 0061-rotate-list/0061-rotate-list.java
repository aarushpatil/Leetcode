/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode rotateRight(ListNode head, int k) {
        //link the last node to first and move head forward by n - numrotations

        if(head == null || k == 0)
        {
            return head;
        }

        ListNode fast = head;

        int length = 0;
        while(fast != null)
        {
            fast = fast.next;
            length++;
        }

        fast = head;

        for(int i = 0; i < k % length; i++)
        {
            fast = fast.next;
        }

        ListNode slow = head;
        while(fast.next != null)
        {
            fast = fast.next;
            slow = slow.next;
        }

        fast.next = head;

        head = slow.next;
        slow.next = null;

        return head;
    }
}