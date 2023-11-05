package student;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class DFS implements IPuzzleAlgo {
	private Stack<Node> stack = new Stack<>();
	private List<Node> isCheck = new ArrayList<Node>();

	@Override
	public Node execute(Puzzle model) {
		// TODO Auto-generated method stub
		int count = 1;
		Node top = null;
		stack.add(model.getInitialState());
		Node goal = model.getGoalState();
		while(!stack.isEmpty()) {
			top = stack.pop();
			System.out.println(top);
			++count;
			if (top.equals(goal)) {
				break;
			}
			model.getSuccessors(top).forEach(e -> {
				if (!(isCheck.contains(e) || stack.contains(e))) {
					stack.add(e);
					isCheck.add(e);
				}
			});
		}
		System.out.println("So lan thuc hien: " + count);
		return top;
	}

}
