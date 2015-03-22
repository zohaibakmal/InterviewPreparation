package com.test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

/*
 * Breadth first search
 * Maintain a map duplicate nodes. Allows us to see which ones are visited
 * If it does not exist, add it to the map
 * Look at neighbours and add neighbours to the duplicate items
 * 
 * */


public class CloneGraph {

	public UndirectedGraphNode cloneGraph(UndirectedGraphNode node) {
		if (node == null) 
			return null;

		HashMap<Integer, UndirectedGraphNode> map = new HashMap<Integer, UndirectedGraphNode>();
		LinkedList<UndirectedGraphNode> queue = new LinkedList<UndirectedGraphNode>();
		queue.offer(node);
		UndirectedGraphNode curNode = null;

		//FIFO
		while (!queue.isEmpty()) {
			curNode = queue.poll();
			if (!map.containsKey(curNode.label)) 
				map.put(curNode.label, new UndirectedGraphNode(curNode.label));         
			if (null != curNode.neighbors) {
				for (UndirectedGraphNode neighbor : curNode.neighbors) {
					if (!map.containsKey(neighbor.label)) {
						queue.offer(neighbor);
						map.put(neighbor.label, new UndirectedGraphNode(neighbor.label));       
					}
					map.get(curNode.label).neighbors.add(map.get(neighbor.label));
				}
			}
		}  //end while
		return map.get(node.label);
	}

	class UndirectedGraphNode {
		int label;
		List<UndirectedGraphNode> neighbors;
		UndirectedGraphNode(int x) { label = x; neighbors = new ArrayList<UndirectedGraphNode>(); }
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
