/**
 * Add linked list represented number
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
	public static Node add(Node head1, Node head2) {
		Node dummyHead = new Node(-1);
		Node cur = dummyHead;
		int carry = 0;
		while (head1 != null || head2 != null) {
			int sum;
			if (head1 != null && head2 != null) {
				sum = (head1.val + head2.val + carry);
				head1 = head1.next;
				head2 = head2.next;
			} else if (head1 == null) {
				sum = head2.val + carry;
				head2 = head2.next;
			} else {
				sum = head1.val + carry;
				head1 = head1.next;
			}
			carry = sum / 10;
			cur.next = new Node(sum % 10);
			cur = cur.next;
		}
		if (carry != 0) {
			cur.next = new Node(carry);
		}
		return dummyHead.next;
	}
	
	public static void printList(Node head) {
		while (head != null) {
			System.out.print(head.val + " ");
			head = head.next;
		}
		System.out.println();
	}
	
	public static void main(String[] args) {
		Node head1 = new Node(3);
		head1.next = new Node(1);
		head1.next.next = new Node(5);
		
		Node head2 = new Node(5);
		head2.next = new Node(9);
		head2.next.next = new Node(4);
		
		printList(add(head1, head2));
	}
}
