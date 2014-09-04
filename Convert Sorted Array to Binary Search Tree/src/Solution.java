
class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}

public class Solution {
    public TreeNode sortedArrayToBST(int[] num) {
        return generateBST(num, 0, num.length - 1);
    }
    
    public TreeNode generateBST(int[] num, int start, int end) {
    	if (start > end) {
    		return null;
    	}
    	int mid = (start + end) / 2;
    	TreeNode root = new TreeNode(num[mid]);
    	root.left = generateBST(num, start, mid - 1);
    	root.right = generateBST(num, mid + 1, end);
    	return root;
    }
}
