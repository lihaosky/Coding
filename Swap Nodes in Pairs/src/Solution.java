/**
 *  Given a linked list, swap every two adjacent nodes and return its head.

For example,
Given 1->2->3->4, you should return the list as 2->1->4->3.

Your algorithm should use only constant space. You may not modify the values in the list, only nodes itself can be changed. 
 * @author lihaosky
 *
 */

/**
 * Definition for singly-linked list.
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
    public ListNode swapPairs(ListNode head) {
    	if (head == null || head.next == null) {
    		return head;
    	}
        ListNode cur = head;
        head = head.next;
        ListNode nextNext = head.next;
        head.next = cur;
        cur.next = swapPairs(nextNext);
        return head;
    }
    
    public ListNode reverseKGroup(ListNode head, int k) {
    	if (k <= 1) {
    		return head;
    	}
        ListNode cur = head;
        for (int i = 0; i < k - 1 && cur != null; i++) {
        	cur = cur.next;
        }
        if (cur == null) {
        	return head;
        }
        ListNode pre = null, next;
        cur = head;
        for (int i = 0; i < k; i++) {
        	next = cur.next;
        	cur.next = pre;
        	pre = cur;
        	cur = next;
        }
        head.next = reverseKGroup(cur, k);
        return pre;
    }
}
