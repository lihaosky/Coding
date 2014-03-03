/**
 *  Given a sorted linked list, delete all duplicates such that each element appear only once.
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
    public ListNode deleteDuplicates(ListNode head) {
        if (head == null) {
        	return null;
        }
        ListNode tmpHead = head;
        while (head != null && head.next != null) {
        	if (head.val == head.next.val) {
        		head.next = head.next.next;
        	} else {
        		head = head.next;
        	}
        }
        return tmpHead;
    }
}
