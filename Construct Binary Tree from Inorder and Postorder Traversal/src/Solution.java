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
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        if (inorder.length == 0) {
        	return null;
        }
        int root = postorder[postorder.length - 1];
        TreeNode rootNode = new TreeNode(root);
        int mid;
        for (mid = 0; mid < inorder.length; mid++) {
        	if (inorder[mid] == root) {
        		break;
        	}
        }
        rootNode.left = buildTree(Arrays.copyOfRange(inorder, 0, mid), Arrays.copyOfRange(postorder, 0, mid));
        rootNode.right = buildTree(Arrays.copyOfRange(inorder, mid + 1, inorder.length), Arrays.copyOfRange(postorder, mid, postorder.length - 1));
        return rootNode;
    }
    
    public void preorder(TreeNode root) {
    	if (root != null) {
    		System.out.println(root.val);
    		preorder(root.right);
    		preorder(root.left);
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
    	int[] preorder = {2, 1};
    	int[] inorder = {2, 1};
    	TreeNode root = new Solution().buildTree(preorder, inorder);
    	new Solution().preorder(root);
    	testArrayCopy();
    }
}

