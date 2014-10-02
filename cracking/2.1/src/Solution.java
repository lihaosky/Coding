/**
 * Remove duplicate in a Linked List
 * @author hali3
 *
 */

import java.util.*;

class Node {
	public int val;
	public Node next;
	
	Node(int val) {
		this.val = val;
		next = null;
	}
}

public class Solution {
	public static Node removeDuplicate(Node head) {
		Set<Integer> valueSet = new HashSet<Integer>();
		if (head == null || head.next == null) {
			return head;
		}
		Node cur = head;
		valueSet.add(head.val);
		while (cur.next != null) {
			if (valueSet.contains(cur.next.val)) {
				cur.next = cur.next.next;
			} else {
				valueSet.add(cur.next.val);
				cur = cur.next;
			}
		}
		
		return head;
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
		head.next = new Node(1);
		head.next.next = new Node(2);
		head.next.next.next = new Node(3);
		head.next.next.next.next = new Node(2);
		
		printList(head);
		printList(Solution.removeDuplicate(head));
	}
}
