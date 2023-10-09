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
        HashMap<ListNode, Integer> visited = new HashMap<>();
        ListNode curr = head;
        int index = 0;
        while(curr != null)
        {
            // System.out.println(curr.val);
            if(visited.containsKey(curr))
            {
                return curr;
            }
            visited.put(curr, index);
            index++;
            curr = curr.next;
        }
        return null;
    }
}