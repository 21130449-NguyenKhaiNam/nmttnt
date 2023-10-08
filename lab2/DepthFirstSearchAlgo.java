package k21;

import java.util.List;
import java.util.Stack;

public class DepthFirstSearchAlgo implements ISearchAlgo {
	private Stack<Node> frontier = new Stack<Node>();

	@Override
	public Node execute(Node root, String goal) {
		// TODO Auto-generated method stub
		if (root == null)
			return null;

		if (root.getLabel().equals(goal)) {
			frontier.clear();
			return root;
		}

		List<Node> list = root.getChildrenNodes();
		for (int i = list.size() - 1; i > -1; i--) {
			Node e = list.get(i);
			if (!frontier.contains(e)) {
				frontier.add(e);
				e.setParent(root);
			}
		}

		return execute(frontier.pop(), goal);
	}

	@Override
	public Node execute(Node root, String start, String goal) {
		// TODO Auto-generated method stub
		if (root == null)
			return null;
		Node nodeStart = execute(root, start);
		nodeStart.setParent(null);
		return execute(nodeStart, goal);
	}

	// Tree

	@Override
	public Node executeTree(Node root, String goal) {
		// TODO Auto-generated method stub
		if (root == null)
			return null;

		if (root.getLabel().equals(goal)) {
			frontier.clear();
			return root;
		}

		List<Node> list = root.getChildrenNodes();
		for (int i = list.size() - 1; i > -1; i--) {
			Node e = list.get(i);
			frontier.add(e);
			e.setParent(root);
		}

		return execute(frontier.pop(), goal);
	}

	@Override
	public Node executeTree(Node root, String start, String goal) {
		// TODO Auto-generated method stub
		if (root == null)
			return null;
		Node nodeStart = executeTree(root, start);
		nodeStart.setParent(null);
		return executeTree(nodeStart, goal);
	}

}
