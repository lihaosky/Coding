import java.util.*;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}

public class Solution {
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<Integer>();
        if (root == null) {
        	return res;
        }
        Stack<TreeNode> stack = new Stack<TreeNode>();
        stack.add(root);
        while (!stack.isEmpty()) {
        	TreeNode node = stack.pop();
        	res.add(node.val);
        	System.out.println(node.val);
        	if (node.right != null) {
        		stack.push(node.right);
        	}
        	if (node.left != null) {
        		stack.push(node.left);
        	}
        }
        return res;
    }
    
    public static void main(String[] args) {
    	TreeNode root = new TreeNode(1);
    	TreeNode leftNode = new TreeNode(2);
    	TreeNode rightNode = new TreeNode(3);
    	
    	root.left = leftNode;
    	root.right = rightNode;
    	root.left.left = new TreeNode(6);
    	root.right.right = new TreeNode(5);
    	new Solution().preorderTraversal(root);
    }
}
