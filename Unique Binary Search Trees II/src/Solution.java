import java.util.ArrayList;

/**
 * Given n, generate all structurally unique BST's (binary search trees) that store values 1...n.

For example,
Given n = 3, your program should return all 5 unique BST's shown below.

   1         3     3      2      1
    \       /     /      / \      \
     3     2     1      1   3      2
    /     /       \                 \
   2     1         2                 3

 * @author hali3
 *
 */
class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; left = null; right = null; }
}

public class Solution {
    public ArrayList<TreeNode> generateTrees(int n) {
        return generateSubTree(1, n);
    }
    
    public ArrayList<TreeNode> generateSubTree(int start, int end) {
        if (start > end) {
        	ArrayList<TreeNode> tree = new ArrayList<TreeNode>();
        	tree.add(null);
            return tree;
        }
        ArrayList<TreeNode> res = new ArrayList<TreeNode>();
        for (int i = start; i <= end; i++) {
            ArrayList<TreeNode> left = generateSubTree(start, i - 1);
            ArrayList<TreeNode> right = generateSubTree(i + 1, end);
            for (TreeNode leftNode : left) {
                for (TreeNode rightNode : right) {
                    TreeNode node = new TreeNode(i);
                    node.left = leftNode;
                    node.right = rightNode;
                    res.add(node);
                }
            }
        }
        return res;
    }
}
