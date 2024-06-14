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
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int len1 = 0;
        int len2 = 0;
        ListNode curr = l1;
        while(curr != null)
        {
            curr = curr.next;
            len1++;
        }

        curr = l2;
        while(curr != null)
        {
            curr = curr.next;
            len2++;
        }

        if(len1 < len2)
        {
            for(int i = 0; i < Math.abs(len1 - len2); i++)
            {
                //so len2 is smaller so i gotta add to that hoe
                ListNode newHead = new ListNode(0, l1);
                l1 = newHead;
            }
        }
        else
        {
            for(int i = 0; i < Math.abs(len1 - len2); i++)
            {
                //so len2 is smaller so i gotta add to that hoe
                ListNode newHead = new ListNode(0, l2);
                l2 = newHead;
            }
        }

        recur(l1, l2);

        if(carry == 1)
        {
            ListNode newHead = new ListNode(1, l1);
            l1 = newHead;
        }

        return l1;
    }

    int carry = 0;

    public void recur(ListNode l1, ListNode l2)
    {
        if(l1.next != null)
        {
            recur(l1.next, l2.next);    
        }
        int sum = l1.val + l2.val + carry;

        carry = 0;
        if(sum >= 10)
        {
            sum = sum - 10;
            carry = 1;
        }

        l1.val = sum;
    }
}