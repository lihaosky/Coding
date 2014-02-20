class ListNode {
    int val;
    ListNode next;
    ListNode(int x) {
        val = x;
        next = null;
    }
}
/**
 * Merge two sorted linked lists and return it as a new list. The new list should be made by splicing together the nodes of the first two lists.
 * @author hali3
 *
 */
public class Solution {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode dummyHead = new ListNode(-1);
        ListNode currentNode = dummyHead;
        while (l1 != null || l2 != null) {
        	if (l1 == null) {
        		currentNode.next = l2;
        		l2 = l2.next;
        	} else if (l2 == null) {
        		currentNode.next = l1;
        		l1 = l1.next;
        	} else {
        		if (l1.val < l2.val) {
        			currentNode.next = l1;
        			l1 = l1.next;
        		} else {
        			currentNode.next = l2;
        			l2 = l2.next;
        		}
        	}
        	currentNode = currentNode.next;
        }
        currentNode.next = null;
        return dummyHead.next;
    }
}
