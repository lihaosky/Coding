import java.util.*;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}

public class Solution {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        Queue<TreeNode> layerQueue = new LinkedList<TreeNode>();
        List<Integer> layerList = new ArrayList<Integer>();
        
        int curLayer = 1;
        int nextLayer = 0;
        
        if (root != null) {
        	layerQueue.add(root);
        }
        boolean leftToRight = true;
        while (!layerQueue.isEmpty()) {
        	TreeNode node = layerQueue.remove();
        	layerList.add(node.val);
        	curLayer--;
        	if (node.left != null) {
        		layerQueue.add(node.left);
        		nextLayer++;
        	}
        	if (node.right != null) {
        		layerQueue.add(node.right);
        		nextLayer++;
        	}
        	if (curLayer == 0) {
        		curLayer = nextLayer;
        		nextLayer = 0;
        		if (leftToRight) {
        			result.add(layerList);
        			leftToRight = false;
        		} else {
        			Collections.reverse(layerList);
        			result.add(layerList);
        			leftToRight = true;
        		}
        		layerList = new ArrayList<Integer>();
        	}
        }
        return result;
    }
}
