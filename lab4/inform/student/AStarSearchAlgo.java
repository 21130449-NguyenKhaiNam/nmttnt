package lab4.inform.student;

import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;

public class AStarSearchAlgo implements IInformedSearchAlgo {

	private Queue<Node> nodes = new PriorityQueue<>(new Comparator<Node>() {

		@Override
		public int compare(Node o1, Node o2) {
			// TODO Auto-generated method stub
			return (int) ((o1.getG() + o1.getH()) - (o2.getH() + o2.getG()));
		}
	});

	@Override
	public Node execute(Node root, String goal) {
		// TODO Auto-generated method stub
		if (root == null || root.getLabel().equals(goal)) {
			nodes.clear();
			return root;
		}

		List<Node> listNode = root.getChildrenNodes();
		List<Edge> listEdge = root.getChildren();

		for (int i = 0; i < listNode.size(); i++) {
			if (nodes.contains(listNode.get(i))) {
				double p = listNode.get(i).getG();
				double n = root.getG() + listEdge.get(i).getWeight();
				if (p > n) {
					listNode.get(i).setG(n);
					listNode.get(i).setParent(root);
				}
			} else {
				listNode.get(i).setG(root.getG() + listEdge.get(i).getWeight());
				nodes.add(listNode.get(i));
				listNode.get(i).setParent(root);
			}
		}

		return execute(nodes.poll(), goal);
	}

	@Override
	public Node execute(Node root, String start, String goal) {
		// TODO Auto-generated method stub
		Node node = execute(root, start);
		node.setParent(null);
		node.setG(0);
		return execute(node, goal);
	}

	@Override
	public Node executeTree(Node root, String goal) {
		// TODO Auto-generated method stub
		if (root == null || root.getLabel().equals(goal)) {
			nodes.clear();
			return root;
		}

		List<Node> listNode = root.getChildrenNodes();
		List<Edge> listEdge = root.getChildren();

		for (int i = 0; i < listNode.size(); i++) {
			listNode.get(i).setG(root.getG() + listEdge.get(i).getWeight());
			nodes.add(listNode.get(i));
			listNode.get(i).setParent(root);
		}

		return execute(nodes.poll(), goal);
	}

	@Override
	public Node executeTree(Node root, String start, String goal) {
		// TODO Auto-generated method stub
		Node node = execute(root, start);
		node.setParent(null);
		node.setG(0);
		return execute(node, goal);
	}

	public boolean isAdmissibleH(Node root, String goal) {
		// TODO Auto-generated method stub
		Node tmp;
		Node node = execute(root, goal);
		double hS = node.getG();
		while ((tmp = node.getParent()) != null) {
			hS += node.getG();
			node = tmp;
		}
		if (root.getH() > hS) {
			return false;
		}
		for (Node node2 : root.getChildrenNodes()) {
			if(!isAdmissibleH(node2, goal)) {
				return false;
			}
		}
		return true;
	}

}
