package student;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

public class HillClimbing implements IPuzzleAlgo {
	private PriorityQueue<Node> frontier = new PriorityQueue<Node>(PuzzleUtils.HeuristicComparatorByH);
	private List<Node> isCheck = new ArrayList<Node>();
	
	@Override
	public Node execute(Puzzle model) {
		// TODO Auto-generated method stub
		Node top = null;
		int count = 1;
		Node init = model.getInitialState();
		init.setH(model.computeH2(model.getInitialState()));
		Node goal = model.getGoalState();
		frontier.add(init);
		while(!frontier.isEmpty()) {
			if (top == null) {
				top = frontier.poll();
				++count;
				if(top.equals(goal)) {
					break;
				}
			} else {
				Node tmp = frontier.poll();
				if(tmp.getH() < top.getH()) {
					top = tmp;
					++count;
					if(top.equals(goal)) {
						break;
					}
					frontier.clear();
					model.getSuccessors(top).forEach(e -> {
						if (!isCheck.contains(e)) {
							e.setH(model.computeH2(e));
							frontier.add(e);
							isCheck.add(e);
						}
					});
				}
			}
		}
		System.out.println("So lan thuc hien: " + count);
		return top;
	}

}
