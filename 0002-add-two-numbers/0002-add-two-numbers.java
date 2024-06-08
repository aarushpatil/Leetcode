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
         
        ListNode curr = l1;
        ListNode curr2 = l2;
        ListNode ans = new ListNode();

        ListNode currAns = ans;

        ListNode last1 = null;
        ListNode last2 = null;

        boolean carry = false;
        while(curr.next != null || curr2.next != null)
        {
            int theVal = (carry) ? curr.val + curr2.val + 1 : curr.val + curr2.val;
            carry = false;

            if(theVal >= 10)
            {
                carry = true;
                theVal = theVal % 10;
            }

            currAns.next = new ListNode(theVal);
            currAns = currAns.next;
            if(curr.next != null)
            {
                curr = curr.next;
            }
            else
            {
                curr = new ListNode(0);
                last1 = curr;
            }
            if(curr2.next != null)
            {
                curr2 = curr2.next;
            }
            else
            {
                curr2 = new ListNode(0);
                last2 = curr2;
            }
        }

        // curr = curr.next;
        // curr2 = curr2.next;
        
        curr = (last1 != null) ? last1 : curr;
        curr2 = (last2 != null) ? last2 : curr2;

        int theVal = (carry) ? curr.val + curr2.val + 1 : curr.val + curr2.val;
        carry = false;
        if(theVal >= 10)
        {
            carry = true;
            theVal = theVal % 10;
        }

        currAns.next = new ListNode(theVal);
        
        if(carry)
        {
            currAns = currAns.next;
            currAns.next = new ListNode(1);
        }

        return ans.next;
    }
}