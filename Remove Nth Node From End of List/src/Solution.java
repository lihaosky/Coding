/**
 * Given a linked list, remove the nth node from the end of list and return its head.
 * @author lihaosky
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
	public ListNode removeNthFromEnd(ListNode head, int n) {
		if (head == null) {
			return null;
		}
        ListNode end = head;
        for (int i = 0; i < n; i++) {
        	end = end.next;
        }
        ListNode target = head, preTarget = null;
        while (end != null) {
        	end = end.next;
        	preTarget = target;
        	target = target.next;
        }
        if (preTarget == null) {
        	return head.next;
        }
        preTarget.next = target.next;
        return head;
    }
	
	public static void main(String[] args) {
		ListNode head, node;
		node = new ListNode(1);
		head = node;
		node.next = new ListNode(2);
		node = node.next;
		node.next = new ListNode(3);
		node = node.next;
		node.next = new ListNode(4);
		node = node.next;
		node.next = new ListNode(5);
		node = node.next;
		
		head = new Solution().removeNthFromEnd(head, 5);
		ListNode tmp = head;
		while (tmp != null) {
			System.out.println(tmp.val);
			tmp = tmp.next;
		}
	}
}
