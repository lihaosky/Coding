/**

You must do this in-place without altering the nodes' values.

For example,
Given {1,2,3,4}, reorder it to {1,4,2,3}. 
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
    public ListNode reorderList(ListNode head) {
    	if (head == null || head.next == null) {
    		return head;
    	}
        int len = 0;
        for (ListNode cur = head; cur != null; cur = cur.next) {
        	len++;
        }
        ListNode cur = head;
        for (int i = 0; i < len / 2 - 1; i++) {
        	cur = cur.next;
        }
        ListNode rightHead = cur.next;
        cur.next = null;
        rightHead = reverse(rightHead);
        ListNode dummyHead = new ListNode(-1);
        cur = dummyHead;
        while (head != null || rightHead != null) {
        	if (head == null) {
        		cur.next = rightHead;
        		rightHead = rightHead.next;
        	} else if (rightHead == null) {
        		cur.next = head;
        		head = head.next;
        	} else {
        		cur.next = head;
        		head = head.next;
        		cur = cur.next;
        		cur.next = rightHead;
        		rightHead = rightHead.next;
        	}
        	cur = cur.next;
        }
        cur.next = null;
        return dummyHead.next;
    }
    
    public ListNode reverse(ListNode head) {
    	ListNode pre = null, cur = head;
    	while (cur != null) {
    		ListNode tmp = cur.next;
    		cur.next = pre;
    		pre = cur;
    		cur = tmp;
    	}
    	return pre;
    }
    
    public static void main(String[] args) {
    	ListNode l1 = new ListNode(1);
    	ListNode l2 = new ListNode(2);
    	l1.next = l2;
    	ListNode h = new Solution().reorderList(l1);
    }
}
