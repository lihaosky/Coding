/**
 *  Reverse a linked list from position m to n. Do it in-place and in one-pass.

For example:
Given 1->2->3->4->5->NULL, m = 2 and n = 4,

return 1->4->3->2->5->NULL.

Note:
Given m, n satisfy the following condition:
1 ≤ m ≤ n ≤ length of list. 
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
    public ListNode reverseBetween(ListNode head, int m, int n) {
        ListNode dummyNode = new ListNode(-1);
        dummyNode.next = head;
        ListNode preNode = dummyNode;
        ListNode curNode = head;
        for (int i = 0; i < m - 1; i++) {
            preNode = curNode;
            curNode = curNode.next;
        }
        ListNode newTail = curNode;
        ListNode pre = curNode;
        curNode = curNode.next;
        for (int i = m; i < n; i++) {
            ListNode tmpNode = curNode.next;
            curNode.next = pre;
            pre = curNode;
            curNode = tmpNode;
        }
        newTail.next = curNode;
        preNode.next = pre;
        return dummyNode.next;
    }
}
