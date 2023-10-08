package k21;

import java.util.List;
import java.util.PriorityQueue;

public class UniformCostSearchAlgo implements ISearchAlgo {
	PriorityQueue<Node> frontier = new PriorityQueue<Node>(new
			NodeComparator());


	@Override
	public Node execute(Node root, String goal) {
		// TODO Auto-generated method stub
		if(root.getLabel().equals(goal)) {
			frontier.clear();
			return root;
		}
		
		List<Node> nodes = root.getChildrenNodes();
		List<Edge> edges = root.getChildren();
		
		for (int i = 0; i < nodes.size(); i++) {
			if(!frontier.contains(nodes.get(i))) {
				nodes.get(i).setPathCost(root.getPathCost() + edges.get(i).getWeight());
				frontier.add(nodes.get(i));
				nodes.get(i).setParent(root);
			}
		}
		
		return execute(frontier.remove(), goal);
	}

	@Override
	public Node execute(Node root, String start, String goal) {
		// TODO Auto-generated method stub
		Node node = execute(root, start);
		node.setParent(null);
		node.setPathCost(0);
		return execute(node, goal);
	}

	@Override
	public Node executeTree(Node root, String goal) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Node executeTree(Node root, String start, String goal) {
		// TODO Auto-generated method stub
		return null;
	}

}
