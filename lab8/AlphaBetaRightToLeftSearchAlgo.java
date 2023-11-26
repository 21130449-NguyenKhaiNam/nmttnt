package game_alphabeta_student;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class AlphaBetaRightToLeftSearchAlgo implements ISearchAlgo {
	int max = 1;

	@Override
	public void execute(Node node) {
		// TODO Auto-generated method stub
		node.setValue(maxValue(node, Integer.MIN_VALUE, Integer.MAX_VALUE));
	}

	// function MAX-VALUE(state, alpha, beta) returns a utility value
	// if TERMINAL-TEST(state) then return UTILITY(state)
	// v <- MIN_VALUE;
	// for each s in SUCCESSORS(state) do
	// v <- MAX(v, MIN-VALUE(s, alpha, beta))
	// if v >= beta then return v
	// alpha <- MAX(alpha, v)
	// return v

	public int maxValue(Node node, int alpha, int beta) {
		// Enter your code here
		if (node.isTerminal()) {
			return node.getValue();
		}
		int v = Integer.MIN_VALUE;
		boolean flag = true;
		List<Node> reverse = new ArrayList<Node>();
		reverse.addAll(node.getChildren());
		Collections.reverse(reverse);
		for (Node n : reverse) {
			if (max > 0) {
				if (flag) {
					v = Math.max(v, minValue(n, alpha, beta));
					if (!n.isTerminal())
						n.setValue(v);
					if (v >= beta) {
						flag = false;
					}
					alpha = Math.max(alpha, v);
				} else {
					System.out.println("Bi cat: " + n.getLabel());
				}
			}
		}
		--max;
		return v;
	}
	// function MIN-VALUE(state, alpha , beta) returns a utility value
	// if TERMINAL-TEST(state) then return UTILITY(state)
	// v <- Integer.MAX_VALUE
	// for each s in SUCCESSORS(state) do
	// v <- MIN(v, MAX-VALUE(s, alpha , beta))
	// if v <= alpha then return v
	// beta <- MIN(beta ,v)
	// return v

	public int minValue(Node node, int alpha, int beta) {
		// Enter your code here
		if (node.isTerminal()) {
			return node.getValue();
		}
		int v = Integer.MAX_VALUE;
		boolean flag = true;
		List<Node> reverse = new ArrayList<Node>();
		reverse.addAll(node.getChildren());
		Collections.reverse(reverse);
		for (Node n : reverse) {
			if (max > 1) {
				if (flag) {
					v = Math.min(v, maxValue(n, alpha, beta));
					if (!n.isTerminal())
						n.setValue(v);
					if (v <= alpha) {
						flag = false;
					}
					beta = Math.min(beta, v);
				} else {
					System.out.println("Bi cat: " + n.getLabel());
				}
			}
		}
		--max;
		return v;
	}

}
