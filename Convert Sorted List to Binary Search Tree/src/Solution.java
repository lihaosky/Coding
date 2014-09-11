import java.util.*;

class ListNode {
    int val;
    ListNode next;
    ListNode(int x) { val = x; next = null; }
}



class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}

public class Solution {
	private ListNode currentNode;
	
    public TreeNode sortedListToBST(ListNode head) {
        int len = 0;
        ListNode node = head;
        while (node != null) {
        	len++;
        	node = node.next;
        }
        currentNode = head;
        return constructBST(len);
    }
    
    public TreeNode constructBST(int n) {
    	if (n <= 0) {
    		return null;
    	}
    	int mid = (n + 1) / 2;
    	int leftLen = mid - 1;
    	int rightLen = n - mid;
    	
    	TreeNode leftChild = constructBST(leftLen);
    	TreeNode parentNode = new TreeNode(currentNode.val);
    	currentNode = currentNode.next;
    	TreeNode rightChild = constructBST(rightLen);
    	parentNode.left = leftChild;
    	parentNode.right = rightChild;
    	return parentNode;
    }
    
    public int findDepth(TreeNode root) {
    	if (root == null) {
    		return 0;
    	}
    	return Math.max(findDepth(root.left), findDepth(root.right)) + 1;
    }
    
    public static void print(TreeNode root) {
        Queue<TreeNode> layerQueue = new LinkedList<TreeNode>();
        
        int curLayer = 1;
        int nextLayer = 0;
        
        if (root != null) {
        	layerQueue.add(root);
        }

        while (!layerQueue.isEmpty()) {
        	TreeNode node = layerQueue.remove();
        	System.out.print(node.val + " ");
        	curLayer--;
        	if (node.left != null) {
        		layerQueue.add(node.left);
        		nextLayer++;
        	}
        	if (node.right != null) {
        		layerQueue.add(node.right);
        		nextLayer++;
        	}
        	if (curLayer == 0) {
        		curLayer = nextLayer;
        		nextLayer = 0;
        		System.out.println();
        	}
        }
    }
    
    public static void main(String[] args) {
    	ListNode head = new ListNode(1);
    	ListNode node1 = new ListNode(2);
    	ListNode node2 = new ListNode(3);
    	ListNode node3 = new ListNode(4);
    	
    	head.next = node1;
    	node1.next = node2;
    	node2.next = node3;
    	
    	print(new Solution().sortedListToBST(head));
    }
}
