class TreeNode {
	int val;
	TreeNode left;
	TreeNode right;
	
	public TreeNode(int val) {
		this.val = val;
		left = null;
		right = null;
	}
}
public class BinaryTree {
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
	
	public static void preorder(TreeNode root) {
		if (root == null) {
			return;
		}
		System.out.print(root.val + " ");
		preorder(root.left);
		preorder(root.right);
	}
	
	public static void main(String[] args) {
		int[] array = {1, 2, 3, 4, 5, 6};
		preorder(createFromArray(array));
	}
}
