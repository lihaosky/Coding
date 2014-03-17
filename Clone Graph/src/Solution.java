import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;

/**
 * Clone an undirected graph. Each node in the graph contains a label and a list of its neighbors. 
 * @author hali3
 *
 */

class UndirectedGraphNode {
    int label;
    ArrayList<UndirectedGraphNode> neighbors;
    UndirectedGraphNode(int x) { label = x; neighbors = new ArrayList<UndirectedGraphNode>(); }
}
public class Solution {
	public UndirectedGraphNode cloneGraph(UndirectedGraphNode node) {
		if (node == null) {
			return null;
		}
		HashSet<UndirectedGraphNode> visited = new HashSet<UndirectedGraphNode>();
		HashMap<UndirectedGraphNode, UndirectedGraphNode> nodeMap = new HashMap<UndirectedGraphNode, UndirectedGraphNode>();
		Queue<UndirectedGraphNode> queue = new LinkedList<UndirectedGraphNode>();
		UndirectedGraphNode newHead = new UndirectedGraphNode(node.label);
		nodeMap.put(node, newHead);
		queue.add(node);
		visited.add(node);
		while (queue.peek() != null) {
			UndirectedGraphNode tmpNode = queue.remove();
			UndirectedGraphNode cloneNode = nodeMap.get(tmpNode);
			for (UndirectedGraphNode n : tmpNode.neighbors) {
				if (visited.contains(n)) {
					UndirectedGraphNode neighbor = nodeMap.get(n);
					cloneNode.neighbors.add(neighbor);
				} else {
					visited.add(n);
					UndirectedGraphNode newNeighbor = new UndirectedGraphNode(n.label);
					nodeMap.put(n, newNeighbor);
					queue.add(n);
					cloneNode.neighbors.add(newNeighbor);
				}
			}
		}
		return newHead;
	}
}
