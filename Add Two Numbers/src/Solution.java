/* You are given two linked lists representing two non-negative numbers. 
 * The digits are stored in reverse order and each of their nodes contain a single digit. 
 * Add the two numbers and return it as a linked list.
 * Input: (2 -> 4 -> 3) + (5 -> 6 -> 4)
 * Output: 7 -> 0 -> 8
*/

/**
 * Solution: Beware of carries and the last carry.
 * Complexity: O(max(m, n))
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
	public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
		// Note: The Solution object is instantiated only once and is reused by
		// each test case.
		if (l1 == null && l2 == null) {
			return new ListNode(0);
		}
		if (l1 == null) {
			return l2;
		}
		if (l2 == null) {
			return l1;
		}
		
		int carry = 0;
		ListNode head, pre;
		
		head = new ListNode((l1.val + l2.val) % 10);
		carry = (l1.val + l2.val) / 10;
		pre = head;
		
		l1 = l1.next;
		l2 = l2.next;
		while (l1 != null || l2 != null) {
			ListNode tmpNode;
			if (l1 == null) {
				tmpNode = new ListNode((l2.val + carry) % 10);
				carry = (l2.val + carry) / 10;
				l2 = l2.next;
			} else if (l2 == null) {
				tmpNode = new ListNode((l1.val + carry) % 10);
				carry = (l1.val + carry) / 10;
				l1 = l1.next;
			} else {
				tmpNode = new ListNode((l1.val + l2.val + carry) % 10);
				carry = (l1.val + l2.val + carry) / 10;
				l1 = l1.next;
				l2 = l2.next;
			}
			pre.next = tmpNode;
			pre = tmpNode;
		}
		if (carry == 1) {
			pre.next = new ListNode(1);
		}
		
		return head;
	}
	
	public static void main(String[] args) {
		ListNode head = new ListNode(7);
		ListNode pre = head;
		pre.next = new ListNode(8);
		pre = pre.next;
		pre.next = new ListNode(2);
		pre = pre.next;
		pre.next = new ListNode(9);
		ListNode head1 = new ListNode(3);
		pre = head1;
		pre.next = new ListNode(8);
		pre = pre.next;
		pre.next = new ListNode(2);
		pre = pre.next;
		pre.next = new ListNode(9);
		ListNode result = new Solution().addTwoNumbers(head, head1);
		while (result != null) {
			System.out.println(result.val);
			result = result.next;
		}
	}
}
