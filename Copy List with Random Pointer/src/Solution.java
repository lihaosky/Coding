import java.util.*;

//Definition for singly-linked list with a random pointer.
class RandomListNode {
    int label;
    RandomListNode next, random;
    RandomListNode(int x) { this.label = x; }
}


public class Solution {
    public RandomListNode copyRandomList(RandomListNode head) {
        RandomListNode dummy = new RandomListNode(0);
        dummy.next = null;
        HashMap<RandomListNode, RandomListNode> oldToNewMap = new HashMap<RandomListNode, RandomListNode>();
        
        RandomListNode tmpHead = head;
        RandomListNode newTail = dummy;
        while (tmpHead != null) {
        	RandomListNode newNode = new RandomListNode(tmpHead.label);
        	newNode.next = null;
        	newNode.random = null;
        	newTail.next = newNode;
        	newTail = newNode;
        	oldToNewMap.put(tmpHead, newNode);
        	tmpHead = tmpHead.next;
        }
        
        tmpHead = head;
        while (tmpHead != null) {
        	RandomListNode oldTarget = tmpHead.random;
        	if (oldTarget != null) {
        		RandomListNode newTarget = oldToNewMap.get(oldTarget);
        		oldToNewMap.get(tmpHead).random = newTarget;
        	}
        	tmpHead = tmpHead.next;
        }
        
        return dummy.next;
    }
}
