/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode curr = headA;

        int lenA = 0;
        int lenB = 0;
        while(curr != null)
        {
            curr = curr.next;
            lenA++;
        }

        curr = headB;
        while(curr != null)
        {
            curr = curr.next;
            lenB++;
        }

        if(lenB < lenA)
        {
            //swap
            curr = headA;
            headA = headB;
            headB = curr;
        }
        //assumed that lenA is smaller

        for(int i = 0; i < Math.abs(lenA - lenB); i++)
        {
            headB = headB.next;
        }

        while(headB != null)
        {
            if(headA == headB)
            {
                return headA;
            }
            headA = headA.next;
            headB = headB.next;
        }

        return null;
    }
}