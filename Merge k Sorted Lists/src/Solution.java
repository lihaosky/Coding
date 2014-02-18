import java.util.ArrayList;

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

/**
 * Merge k sorted linked lists and return it as one sorted list. Analyze and describe its complexity. 
 * @author hali3
 *
 */
public class Solution {
    public ListNode mergeKLists(ArrayList<ListNode> lists) {
    	ArrayList<ListNode> heads = new ArrayList<ListNode>();
    	for (ListNode node : lists) {
    		heads.add(node);
    	}
    	ListNode headNode = new ListNode(0), currentNode = headNode;
    	ListNode smallestNode;
    	while ((smallestNode = getSmallest(heads)) != null) {
    			currentNode.next = smallestNode;
    			currentNode = smallestNode;
    	}
    	return headNode.next;
    }
    
    public ListNode getSmallest(ArrayList<ListNode> lists) {
    	int index = -1;
    	int min = Integer.MAX_VALUE;
    	for (int i = 0; i < lists.size(); i++) {
    		if (lists.get(i) != null && lists.get(i).val < min) {
    			index = i;
    			min = lists.get(i).val;
    		}
    	}
    	if (index == -1) {
    		return null;
    	}
    	lists.set(index, lists.get(index).next);
    	return new ListNode(min);
    }
}