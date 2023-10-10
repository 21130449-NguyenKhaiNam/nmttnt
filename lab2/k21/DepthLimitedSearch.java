package k21;

import java.awt.Robot;

public class DepthLimitedSearch implements ISearchAlgo {
	private int limit = 5;

	public DepthLimitedSearch(int limit) {
		super();
		this.limit = limit;
	}

	public void setLimit(int limit) {
		this.limit = limit;
	}

	@Override
	public Node execute(Node root, String goal) {
		// TODO Auto-generated method stub
		return subExecute(root, goal, limit);
	}

	private Node subExecute(Node root, String goal, int num) {
		if (root.getLabel().equals(goal)) {
			return root;
		}

		if (num == 0) {
			return null;
		}

		Node re = null;
		for (Node node : root.getChildrenNodes()) {
			node.setParent(root);
			re = subExecute(node, goal, num - 1);
			if (re != null) {
				break;
			}
		}
		return re;
	}

	@Override
	public Node execute(Node root, String start, String goal) {
		// TODO Auto-generated method stub
		Node node = execute(root, start);
		node.setParent(null);
		return execute(node, goal);
	}

	@Override
	public Node executeTree(Node root, String goal) {
		// TODO Auto-generated method stub
		return subExecute(root, goal, limit);
	}

	@Override
	public Node executeTree(Node root, String start, String goal) {
		// TODO Auto-generated method stub
		Node node = executeTree(root, start);
		node.setParent(null);
		return executeTree(node, goal);
	}

}
