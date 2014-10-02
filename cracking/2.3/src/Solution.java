/**
 * 
 * @author hali3
 *
 */
class Node {
	public int val;
	public Node next;
	public Node(int val) {
		this.val = val;
		next = null;
	}
}

public class Solution {
	public static void deleteMid(Node node) {
		Node cur = node;
		while (node.next != null) {
			node.val = node.next.val;
			cur = node;
			node = node.next;
		}
		cur.next = null;
	}
	
	public static void printList(Node head) {
		while (head != null) {
			System.out.print(head.val + " ");
			head = head.next;
		}
		System.out.println();
	}
	
	public static void main(String[] args) {
		Node head = new Node(1);
		head.next = new Node(2);
		head.next.next = new Node(3);
		head.next.next.next = new Node(4);
		Node node = head.next.next;
		
		printList(head);
		deleteMid(node);
		printList(head);
	}
}
