package cloneGraph;

import java.util.*;

public class Solution {
	 static class UndirectedGraphNode {
	     int label;
	     ArrayList<UndirectedGraphNode> neighbors;
	     UndirectedGraphNode(int x) { label = x; neighbors = new ArrayList<UndirectedGraphNode>(); }
	 }
	 
	 public static void main(String[] args) {
		 UndirectedGraphNode node = new UndirectedGraphNode(0);
		 node.neighbors.add(node);
		 node.neighbors.add(node);
		 node.neighbors.add(node);
		 
		 UndirectedGraphNode newNode = (new Solution()).cloneGraph(node);
		 
		 System.out.println(node == newNode);
	 }
	 
    public UndirectedGraphNode cloneGraph(UndirectedGraphNode node) {
    	if (node == null)
    		return null;
    	
        Set<Integer> visited = new HashSet<Integer>(); // visited node
        Map<Integer, UndirectedGraphNode> nnMap = new HashMap<Integer, UndirectedGraphNode>(); // map of new nodes
        Queue<UndirectedGraphNode> queue = new LinkedList<UndirectedGraphNode>(); // queue for BFS
        
        // first round of BFS: constructing the nodes
        queue.add(node);
        visited.add(node.label); // mark as visited
        while (!queue.isEmpty()) {
        	UndirectedGraphNode curNode = queue.remove();
        	
        	UndirectedGraphNode newNode = nnMap.get(curNode.label);
        	if (newNode == null) {
        		newNode = new UndirectedGraphNode(curNode.label);
        		nnMap.put(curNode.label, newNode);
        	}
        	
        	for (int i = 0; i < curNode.neighbors.size(); i++) {
        		UndirectedGraphNode nb = curNode.neighbors.get(i);
        		
        		UndirectedGraphNode newNb = nnMap.get(nb.label);
        		if (newNb == null) {
        			newNb = new UndirectedGraphNode(nb.label);
        			nnMap.put(nb.label, newNb);
        		}
        		newNode.neighbors.add(newNb);
        		
        		if (!visited.contains(nb.label)) {
        			queue.add(nb);
        			visited.add(nb.label);
        		} 
        	} // end for
        } // end while        
        
        return nnMap.get(node.label);  
    }
}