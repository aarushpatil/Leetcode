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
    public ListNode detectCycle(ListNode head) {
        HashSet<ListNode> visited = new HashSet<>();
        ListNode curr = head;
        while(curr != null)
        {
            // System.out.println(curr.val);
            if(visited.contains(curr))
            {
                return curr;
            }
            visited.add(curr);
            curr = curr.next;
        }
        return null;
    }
}