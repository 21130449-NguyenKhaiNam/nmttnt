package student;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

public class Greedy implements IPuzzleAlgo {
	private PriorityQueue<Node> frontier = new PriorityQueue<Node>(PuzzleUtils.HeuristicComparatorByH);
	private List<Node> isCheck = new ArrayList<Node>();
	
	@Override
	public Node execute(Puzzle model) {
		// TODO Auto-generated method stub
		Node init = model.getInitialState();
		init.setH(model.computeH2(init));
		frontier.add(init);
		isCheck.add(init);
		while (!frontier.isEmpty()) {
			Node top = frontier.poll();
			if (top.getH() == 0)
				return top;
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
