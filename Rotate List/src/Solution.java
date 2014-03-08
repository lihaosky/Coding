/**
 * Given a list, rotate the list to the right by k places, where k is non-negative.

For example:
Given 1->2->3->4->5->NULL and k = 2,
return 4->5->1->2->3->NULL.
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
    public ListNode rotateRight1(ListNode head, int n) {
        if (head == null) {
            return head;
        }
        int listLen = 0;
        for (ListNode node = head; node != null; node = node.next) {
            listLen++;
        }
        n = n % listLen;
        if (n == 0) {
            return head;
        }
        ListNode newHead = head;
        for (int i = 0; i < n; i++) {
            newHead = newHead.next;
        }
        ListNode endNode = head;
        while (newHead.next != null) {
            endNode = endNode.next;
            newHead = newHead.next;
        }
        ListNode h = endNode.next;
        endNode.next = null;
        newHead.next = head;
        return h;
    }
	public ListNode rotateRight(ListNode head, int n) {
		if (head == null || n == 0) {
			return head;
		}
		int len = 0;
		for (ListNode node = head; node != null; node = node.next) {
			len++;
		}
		n %= len;
		ListNode node = head;
		while (node.next != null) {
			node = node.next;
		}
		node.next = head;
		node = head;
		for (int i = 0; i < len - n - 1; i++) {
			node = node.next;
		}
		ListNode newHead = node.next;
		node.next = null;
		return newHead;
	}
}
