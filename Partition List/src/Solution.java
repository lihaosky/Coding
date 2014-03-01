/**
 * Given a linked list and a value x, partition it such that all nodes less than x come before nodes greater than or equal to x.

You should preserve the original relative order of the nodes in each of the two partitions.

For example,
Given 1->4->3->2->5->2 and x = 3,
return 1->2->2->4->3->5. 
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
    public ListNode partition(ListNode head, int x) {
        ListNode dummyNode = new ListNode(-1);
        dummyNode.next = head;
        ListNode smallNode = dummyNode;
        ListNode currentNode = dummyNode;
        
        while (currentNode.next != null) {
        	if (currentNode.next.val < x) {
        		if (currentNode != smallNode) {
        		ListNode tmpNode = currentNode.next;
        		currentNode.next = tmpNode.next;
        		tmpNode.next = smallNode.next;
        		smallNode.next = tmpNode;
        		smallNode = tmpNode;
        		} else {
        			smallNode = currentNode.next;
        			currentNode = currentNode.next;
        		}
        	} else {
        		currentNode = currentNode.next;
        	}
        }
        
        return dummyNode.next;
    }
    
    public static void printList(ListNode head) {
    	while (head != null) {
    		System.out.print(head.val + " ");
    		head = head.next;
    	}
    }
    
    public static void main(String[] args) {
    	ListNode node = new ListNode(3);
    	ListNode head = node;
    	printList(new Solution().partition(head, 3));
    }
}
