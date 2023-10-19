package lab4.inform.student;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

public class GreedyBestFirstSearchAlgo implements IInformedSearchAlgo {
	private Queue<Node> nodes = new PriorityQueue<Node>(new Comparator<Node>() {

		@Override
		public int compare(Node o1, Node o2) {
			// TODO Auto-generated method stub
			return (int) (o1.getH() - o2.getH());
		}
	});

	@Override
	public Node execute(Node root, String goal) {
		// TODO Auto-generated method stub
		if (root == null || root.getLabel().equals(goal)) {
			nodes.clear();
			return root;
		}

		for (Node node : root.getChildrenNodes()) {
			if (!nodes.contains(node)) {
				node.setParent(root);
				nodes.add(node);
			}
		}
		return execute(nodes.poll(), goal);
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
		if (root == null || root.getLabel().equals(goal)) {
			nodes.clear();
			return root;
		}

		for (Node node : root.getChildrenNodes()) {
			node.setParent(root);
			nodes.add(node);
		}
		return execute(nodes.poll(), goal);
	}

	@Override
	public Node executeTree(Node root, String start, String goal) {
		// TODO Auto-generated method stub
		Node node = execute(root, start);
		node.setParent(null);
		return execute(node, goal);
	}


}
