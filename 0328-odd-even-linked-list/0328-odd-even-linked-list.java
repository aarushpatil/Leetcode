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
    public ListNode oddEvenList(ListNode head) {

        if(head == null || head.next == null)
        {
            return head;
        }
        ListNode curr = head;
        ListNode oddPtr = curr;
        ListNode even = curr.next;

        while(oddPtr != null && oddPtr.next != null && oddPtr.next.next != null)
        {
            ListNode prev = oddPtr.next;
            oddPtr = oddPtr.next.next;
            prev.next = oddPtr.next;
            curr.next = oddPtr;
            curr = curr.next;
        }
        oddPtr.next = even;

        return head;
    }
}