package student;

import java.util.Arrays;
import java.util.List;

public class TestNode {

	public static void main(String[] args) {
		Puzzle p = new Puzzle();
		p.readInput("./src/txt/PuzzleMap.txt", "./src/txt/PuzzleGoalState.txt");

		Node initialState = p.getInitialState();
		Node tmp = new Node(initialState);
		System.out.println(initialState.equals(tmp));
		Node goalState = p.getGoalState();
		System.out.println(p.getInitialState());
		p.computeH1(initialState);
		System.out.println("H: " + initialState.getH());
		System.out.println(Arrays.toString(initialState.getWhiteTilePosition()));
		System.out.println(p.getGoalState());
		Node re = p.moveWhiteTile(initialState, 'r');

		System.out.println("-------------");
		System.out.println(re);
		System.out.println(re.getH());
		System.out.println(initialState);
		System.out.println(Arrays.toString(re.getWhiteTilePosition()));
		System.out.println("-------------");

//		System.out.println(p.computeH(initialState, goalState));

//		System.out.println(p.getInitialState());
//		System.out.println(p.getGoalState());
//
//		System.out.println("---------------");
//		List<Node> children = p.getSuccessors(initialState);
//		System.out.println("Size: " + children.size());
//		for (Node child : children) {
//			System.out.println("H: " + p.computeH2(child));
//		}
	}
}
