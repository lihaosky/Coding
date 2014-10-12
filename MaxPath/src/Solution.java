/**
 * Find max sum of two leaves in binary tree
 * @author hali3
 *
 */

class TreeNode {
	int val;
	TreeNode left;
	TreeNode right;
	
	TreeNode(int val) {
		this.val = val;
		left = right = null;
	}
}

public class Solution {
	public static int maxPath(TreeNode root) {
		return max(root)[0];
	}
	
	public static int[] max(TreeNode root) {
		if (root == null) {
			return new int[] {0, 0};
		}
		int[] leftMax = max(root.left);
		int[] rightMax = max(root.right);
		System.out.println("Current is " + root.val);
		System.out.println("Max left is " + leftMax[0]);
		System.out.println("Max right is " + rightMax[0]);
		System.out.println("Max left path is " + leftMax[1]);
		System.out.println("Max right path is " + rightMax[1]);
		System.out.println("====================================");
		int[] max = new int[2];
		max[0] = Math.max(leftMax[0], rightMax[0]);
		max[0] = Math.max(max[0], leftMax[1] + rightMax[1] + root.val);
		max[1] = Math.max(leftMax[1], rightMax[1]) + root.val;
		return max;
	}
	
	public static void preorder(TreeNode root) {
		if (root != null) {
			System.out.print(root.val + " ");
			preorder(root.left);
			preorder(root.right);
		}
	}
	
	public static void main(String[] args) {
		TreeNode root = new TreeNode(-15);
		root.left = new TreeNode(5);
		root.left.left = new TreeNode(-8);
		root.left.right = new TreeNode(1);
		root.left.left.left = new TreeNode(2);
		root.left.left.right = new TreeNode(6);
		root.right = new TreeNode(6);
		root.right.left = new TreeNode(3);
		root.right.right = new TreeNode(9);
		root.right.right.right = new TreeNode(0);
		root.right.right.right.left = new TreeNode(4);
		root.right.right.right.right = new TreeNode(-1);
		root.right.right.right.right.left = new TreeNode(10);
		preorder(root);
		System.out.println(Solution.maxPath(root));
	}
}
