package student;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BFS implements IPuzzleAlgo {
	private Queue<Node> queue = new LinkedList<>();
	private List<Node> isCheck = new ArrayList<Node>();
	
	@Override
	public Node execute(Puzzle model) {
		// TODO Auto-generated method stub
		int count = 1;
		Node top = null;
		Node goal = model.getGoalState();
		queue.add(model.getInitialState());
		while(!queue.isEmpty()) {
			top = queue.poll();
			++count;
			if (top.equals(goal)) {
				break;
			}
			model.getSuccessors(top).forEach(e -> {
				if (!(queue.contains(e) || isCheck.contains(e))) {
					queue.add(e);
					isCheck.add(e);
				}
			});
		}
		System.out.println("So lan thuc hien: " + count);
		return top;
	}

}
