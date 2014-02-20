/**
 * Sort a linked list using insertion sort.
 * @author hali3
 *
 */

 class ListNode {
     int val;
     ListNode next;
     ListNode(int x) {
         val = x;
         next = null;
     }
 }
 
public class Solution {
    public ListNode insertionSortList(ListNode head) {
        ListNode dummyHead = new ListNode(Integer.MIN_VALUE);
        while (head != null) {
        	ListNode cur = dummyHead;
        	ListNode tmpHead = head.next;
        	while (cur.next != null && cur.next.val < head.val) {
        		cur = cur.next;
        	}
        	head.next = cur.next;
        	cur.next = head;
        	head = tmpHead;
        }
        return dummyHead.next;
    }
}
