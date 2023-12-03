package game_nim_student;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;

public class MinimaxAlgo {
	private Queue<Node2> q = new LinkedList<Node2>();
	private int win = Integer.MIN_VALUE;

	public void execute(Node node) {
		// Lay duoc cac con
		int v = minValue(node);
		node.setNum(v);
		Node2 node2 = new Node2(null, node);
		q.add(node2);
		while (!q.isEmpty()) {
			Node2 n = q.poll();
			for (Node nc : n.getNode().getChildren()) {
				Node2 n2 = new Node2(n, nc);
				if (nc.getNum() == win && nc.isTerminal()) {
					displayRoad(n2);
					return;
				}
				q.add(n2);
			}
		}
	}

	private void displayRoad(Node2 n2) {
		// TODO Auto-generated method stub
		Stack<Node> print = new Stack<Node>();
		while (n2 != null) {
			print.add(n2.getNode());
			n2 = n2.getParent();
		}
		System.out.println(print);
	}

	// function MAX-VALUE(state) returns a utility value
	// if TERMINAL-TEST(state) then return UTILITY(state)
	// v <- Integer.MIN_VALUE
	// for each s in SUCCESSORS(state) do
	// v <- MAX(v, MIN-VALUE(s))
	// return v
	public int maxValue(Node node) {
		int v = Integer.MIN_VALUE;
		if (!node.isTerminal()) {
			for (Node n : node.getSuccessors()) {
				n.setNum(v);
				v = Math.max(v, minValue(n));
			}
		}
		return v;
	}

	// function MIN-VALUE(state) returns a utility value
	// if TERMINAL-TEST(state) then return UTILITY(state)
	// v <- Integer.MAX_VALUE
	// for each s in SUCCESSORS(state) do
	// v <- MIN(v, MAX-VALUE(s))
	// return v
	public int minValue(Node node) {
		int v = Integer.MAX_VALUE;
		if (!node.isTerminal()) {
			for (Node n : node.getSuccessors()) {
				n.setNum(v);
				v = Math.min(v, maxValue(n));
			}
		}
		return v;
	}
}
