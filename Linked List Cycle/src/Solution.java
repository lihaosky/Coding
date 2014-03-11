/**
 *  Given a linked list, determine if it has a cycle in it.

Follow up:
Can you solve it without using extra space? 
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
	public boolean hasCycle(ListNode head) {
		ListNode fastNode = head;
		ListNode slowNode = head;
		while (fastNode != null && fastNode.next != null) {
			slowNode = slowNode.next;
			fastNode = fastNode.next.next;
			if (slowNode == fastNode) {
				return true;
			}
		}
		return false;
	}
}
