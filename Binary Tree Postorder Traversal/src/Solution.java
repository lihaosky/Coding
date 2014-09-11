import java.util.*;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}

public class Solution {
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<Integer>();
        if (root == null) {
        	return res;
        }
        Stack<TreeNode> stack = new Stack<TreeNode>();
        stack.push(root);
        
        while (!stack.isEmpty()) {
        	TreeNode node = stack.peek();
        	if (node.left == null && node.right == null) {
        		res.add(node.val);
        		stack.pop();
        		while (!stack.isEmpty() && (stack.peek().left == node || stack.peek().right == node)) {
        			res.add(stack.peek().val);
        			node = stack.pop();
        		}
        	} else {
        		if (node.right != null) {
        			stack.push(node.right);
        		} 
        		if (node.left != null) {
        			stack.push(node.left);
        		}
        	}
        }
        return res;
    }
    
    public static void main(String[] args) {
    	TreeNode root = new TreeNode(1);
    	TreeNode leftNode = new TreeNode(2);
    	root.left = leftNode;
    	
    	new Solution().postorderTraversal(root);
    	
    }
}
