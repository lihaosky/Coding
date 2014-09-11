

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}

public class Solution {
	private TreeNode rightMost = null;
	
    public void flatten(TreeNode root) {
    	root = doFlatten(root);
    }
    
    public TreeNode doFlatten(TreeNode root) {
    	if (root == null) {
    		return null;
    	}
    	TreeNode left = doFlatten(root.left);
    	TreeNode tmpRightMost = rightMost;
    	TreeNode right = doFlatten(root.right);
    	if (left == null) {
    		root.right = right;
    		if (right == null) {
    			rightMost = root;
    		}
    	} else {
    		root.right = left;
    		tmpRightMost.right = right;
    	}
    	root.left = null;
    	return root;
    }
}
