/**
 * Definition for binary tree
 */
import java.util.*;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}

public class Solution {
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if (preorder.length == 0) {
        	return null;
        }
        int root = preorder[0];
        TreeNode rootNode = new TreeNode(root);
        int mid;
        for (mid = 0; mid < inorder.length; mid++) {
        	if (inorder[mid] == root) {
        		break;
        	}
        }
        rootNode.left = buildTree(Arrays.copyOfRange(preorder, 1, mid + 1), Arrays.copyOfRange(inorder, 0, mid));
        rootNode.right = buildTree(Arrays.copyOfRange(preorder, mid + 1, preorder.length), Arrays.copyOfRange(inorder, mid + 1, inorder.length));
        return rootNode;
    }
    
    public void postorder(TreeNode root) {
    	if (root != null) {
    		postorder(root.right);
    		postorder(root.left);
    		System.out.println(root.val);
    	}
    }
    
    public static void testArrayCopy() {
    	int[] array = {1, 2, 3, 4};
    	int[] newArray = Arrays.copyOfRange(array, 0, 0);
    	System.out.println("Length: " + newArray.length);
    	for (int i : newArray) {
    		System.out.print(i + " ");
    	}
    }
    public static void main(String[] args) {
    	int[] preorder = {1, 2};
    	int[] inorder = {2, 1};
    	TreeNode root = new Solution().buildTree(preorder, inorder);
    	new Solution().postorder(root);
    	testArrayCopy();
    }
}
