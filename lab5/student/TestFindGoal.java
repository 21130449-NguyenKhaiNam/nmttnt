package student;

public class TestFindGoal {
	public static void main(String[] args) {
		Greedy greedy = new Greedy();
		AStar astar = new AStar();
		Puzzle model = new Puzzle();
		model.readInput("./src/txt/PuzzleMap.txt", "./src/txt/PuzzleGoalState.txt");

//		System.out.println(greedy.execute(model));
		System.out.println(astar.execute(model));
	}
}
