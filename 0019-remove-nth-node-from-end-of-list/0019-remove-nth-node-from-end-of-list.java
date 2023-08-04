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
    public ListNode removeNthFromEnd(ListNode head, int n) {
        //case 1: node to remove is the first node
        //just skip the first node



        //case 2: node to remove is the last node
        //if n = 0, just set the last node to 0

        ListNode first = head;
        ListNode second = head;
        for(int i = 0; i < n; i++)
        {
            second = second.next;
        }

        if(second == null)
        {
            return first.next;
        }

        int counter = n + 1;
        while(second.next != null)
        {
            second = second.next;
            first = first.next;
            counter++;
        }
        
        //if n = 0 then first and second will both be at the last node in the last node
        if(n == 0)
        {
            first = null;
            return head;
        }

        first.next = first.next.next;
        return head;
    }
}