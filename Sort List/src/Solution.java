/**
 * Sort a linked list in O(n log n) time using constant space complexity.
 * 
 * @author hali3
 *
 */

/**
Definition for singly-linked list.
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
	public ListNode sortList(ListNode head) {
		return sortList(head, getLength(head));
	}
	
	public ListNode sortList(ListNode head, int len) {
		if (len == 0) {
			return null;
		}
		if (len == 1) {
			return head;
		}
		int mid = len / 2;
		ListNode rightHead = head;
		for (int i = 0; i < mid - 1; i++) {
			rightHead = rightHead.next;
		}
		ListNode tmp = rightHead;
		rightHead = rightHead.next;
		tmp.next = null;
		head = sortList(head, mid);
		rightHead = sortList(rightHead, len - mid);
		return merge(head, rightHead);
	}
	
	public ListNode merge(ListNode h1, ListNode h2) {
		ListNode dummyHead = new ListNode(-1);
		ListNode curNode = dummyHead;
		
		while (h1 != null || h2 != null) {
			if (h1 == null) {
				curNode.next = h2;
				h2 = h2.next;
			} else if (h2 == null) {
				curNode.next = h1;
				h1 = h1.next;
			} else {
				if (h1.val < h2.val) {
					curNode.next = h1;
					h1 = h1.next;
				} else {
					curNode.next = h2;
					h2 = h2.next;
				}
			}
			curNode = curNode.next;
		}
		curNode.next = null;
		return dummyHead.next;
	}
	
	public int getLength(ListNode head) {
		int len = 0;
		while (head != null) {
			head = head.next;
			len++;
		}
		return len;
	}
	
	public void print(ListNode head) {
		while (head != null) {
			System.out.println(head.val + " ");
			head = head.next;
		}
		System.out.println();
	}
	
	public static void main(String[] args) {
		ListNode n1 = new ListNode(4);
		ListNode n2 = new ListNode(3);
		ListNode n3 = new ListNode(2);
		ListNode n4 = new ListNode(1);
		
		n1.next = n2;
		n2.next = n3;
		n3.next = n4;
		
		ListNode head = new Solution().sortList(n1);
		new Solution().print(head);
	}
}
