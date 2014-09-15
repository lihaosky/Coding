/**
 * Given a tree, and two nodes, find the nearest common ancestor
 * @author hali3
 *
 */
class TreeNode {
	int val;
	TreeNode left;
	TreeNode right;
	
	TreeNode(int val) {
		this.val = val;
		left = null;
		right = null;
	}
}

public class Solution {
	public static TreeNode findCommonAncestor(TreeNode root, TreeNode node1, TreeNode node2) {
		if (node1 == null || node2 == null || root == null) {
			return null;
		}
		if (root == node1 || root == node2) {
			return root;
		}
		TreeNode left = findCommonAncestor(root.left, node1, node2);
		TreeNode right = findCommonAncestor(root.right, node1, node2);
		if ((left == node1 && right == node2) || (left == node2 || right == node1)) {
			return root;
		}
		if (left == null) {
			return right;
		}
		return left;
	}
	
	public static void main(String[] args) {
		TreeNode root = new TreeNode(1);
		root.left = new TreeNode(2);
		root.right = new TreeNode(3);
		root.left.left = new TreeNode(4);
		root.left.right = new TreeNode(5);
		root.right.left = new TreeNode(6);
		root.right.right = new TreeNode(7);
		
		TreeNode node1 = root.left.right;
		TreeNode node2 = root.left.left;
		System.out.println(Solution.findCommonAncestor(root, node1, node2).val);
	}
}
