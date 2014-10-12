/**
 * Find next larger node in binary search tree
 * @author hali3
 *
 */

class TreeNode {
	int val;
	TreeNode left, right, parent;
	TreeNode(int val) {
		this.val = val;
		left = right = parent = null;
	}
}

public class NextNode {
	public static TreeNode findNext(TreeNode node) {
		if (node.right != null) {
			return findLeftMost(node.right);
		}
		
		TreeNode parent = node.parent;
		while (parent != null) {
			if (parent.left == node) {
				return parent;
			}
			node = parent;
			parent = parent.parent;
		}
		
		return null;
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
		root.parent = null;
		root.left = createFromArray(array, start, mid - 1);
		if (root.left != null) {
			root.left.parent = root;
		}
		root.right = createFromArray(array, mid + 1, end);
		if (root.right != null) {
			root.right.parent = root;
		}
		return root;
	}
	
	private static TreeNode findLeftMost(TreeNode root) {
		while (root.left != null) {
			root = root.left;
		}
		return root;
	}
	
	public static void main(String[] args) {
		int[] array = {5, 6, 7, 8, 9, 10, 13, 15, 18, 20, 30};
		TreeNode root = createFromArray(array);
		TreeNode node = root.left.left;
		System.out.println(findNext(node).val);
	}
}
