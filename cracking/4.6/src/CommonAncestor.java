/**
 * Find common ancestor of two nodes in binary tree
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

public class CommonAncestor {
	private static TreeNode sol = null;
	public static TreeNode common(TreeNode root, TreeNode node1, TreeNode node2) {
		commonNum(root, node1, node2);
		return sol;
	}
	
	private static int commonNum(TreeNode root, TreeNode node1, TreeNode node2) {
		if (root == null) {
			return 0;
		}
		if (root == node1 || root == node2) {
			if (commonNum(root.left, node1, node2) == 1 || commonNum(root.right, node1, node2) == 1) {
				sol = root;
				return 2;
			} else {
				return 1;
			}
		}
		int left = commonNum(root.left, node1, node2);
		int right = commonNum(root.right, node1, node2);
		if (left == 1 && right == 1) {
			sol = root;
			return 2;
		}
		return Math.max(left, right);
	}
	
	public static TreeNode createFromArray(int[] array) {
		return createFromArray(array, 0, array.length - 1);
	}
	
	private static TreeNode createFromArray(int[] array, int start, int end) {
		if (start > end) {
			return null;
		}
		int mid = (start + end) / 2;
		TreeNode root = new TreeNode(array[mid]);
		root.left = createFromArray(array, start, mid - 1);
		root.right = createFromArray(array, mid + 1, end);
		return root;
	}
	
	public static void main(String[] args) {
		int[] array = {5, 6, 7, 8, 9, 10, 13, 15, 18, 20, 30};
		TreeNode root = createFromArray(array);
		System.out.println(common(root, root.left.left.right, root.left.right.right).val);
	}
}
