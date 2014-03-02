import java.util.ArrayList;

/**
 *  Two elements of a binary search tree (BST) are swapped by mistake.
 *  Recover the tree without changing its structure. 
 * @author lihaosky
 *
 */

/**
 * Solution is brilliant!
 * @author lihaosky
 *
 */
class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}

public class Solution {
    ArrayList<TreeNode> t;
    TreeNode previous;
    public void recoverTree(TreeNode root) {
        // Start typing your Java solution below
        // DO NOT write main() function
        t = new ArrayList<TreeNode>();
        previous=null;
        inorder(root);
        int temp = t.get(0).val;
        t.get(0).val = t.get(t.size()-1).val;
        t.get(t.size()-1).val = temp;
    }
    public void inorder(TreeNode root) {
        if(root==null) return;
        inorder(root.left);
        if(previous!=null&&previous.val>root.val) {
            if(!t.contains(previous)) t.add(previous);
            if(!t.contains(root)) t.add(root);
        }
        previous = root;
        inorder(root.right);
    }
}
