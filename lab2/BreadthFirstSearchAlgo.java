package k21;

import java.util.LinkedList;
import java.util.Queue;

public class BreadthFirstSearchAlgo implements ISearchAlgo {
	private Queue<Node> frontier = new LinkedList<Node>();

	@Override
	public Node execute(Node root, String goal) {
		// TODO Auto-generated method stub
		if (root == null)
			return null;

		if (root.getLabel().equals(goal)) {
			frontier.clear();
			return root;
		}

		root.getChildrenNodes().forEach(e -> {
			if (!frontier.contains(e)) {
				frontier.add(e);
				e.setParent(root);
			}
		});

		return execute(frontier.poll(), goal);
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

		root.getChildrenNodes().forEach(e -> {
			frontier.add(e);
			e.setParent(root);
		});

		return execute(frontier.poll(), goal);
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
