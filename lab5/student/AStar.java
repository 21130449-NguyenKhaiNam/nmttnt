package student;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;

public class AStar implements IPuzzleAlgo {
	private PriorityQueue<Node> frontier = new PriorityQueue<Node>(PuzzleUtils.HeuristicComparatorByF);
	private List<Node> isCheck = new ArrayList<Node>();
	
	@Override
	public Node execute(Puzzle model) {
		// TODO Auto-generated method stub
		int G = 0;
		Node init = model.getInitialState();
		init.setH(model.computeH2(init));
		init.setG(G);
		frontier.add(init);
		isCheck.add(init);
		while (!frontier.isEmpty()) {
			Node top = frontier.poll();
			if (top.getF() == 0)
				return top;
			++G;
			model.getSuccessors(top).forEach(e -> {
				if (!(frontier.contains(e) || isCheck.contains(e))) {
					frontier.add(e);
					isCheck.add(e);
				}
			});
		}
		return null;
	}

}
