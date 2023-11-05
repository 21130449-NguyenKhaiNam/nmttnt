package student;

import java.time.LocalDateTime;
import java.time.LocalTime;

public class TestOtherAl {
	public static Node time(IPuzzleAlgo al, Puzzle model) {
		long startTime = System.nanoTime();
	    Node node = al.execute(model);
	    long endTime = System.nanoTime();
	    long durationInNanos = endTime - startTime;
	    double durationInMilliseconds = (double) durationInNanos / 1_000_000.0; // Chuyển đổi sang mili giây
	    System.out.println(durationInMilliseconds + "ms");
	    return node;
	}

	public static void main(String[] args) {
		Puzzle model = new Puzzle();
		model.readInput("./src/txt/PuzzleMap.txt", "./src/txt/PuzzleGoalState.txt");
		// Thuat toan se gap van de neu so node con qua lon
//		BFS bfs = new BFS();
//		System.out.println("BFS " + "\n" + time(bfs, model));
		
		// Thuat toan se gap van de vi phai di thu tung nhanh
//		DFS dfs = new DFS(); 
//		System.out.println("DFS " + time(dfs, model));
		
		// Thuat toan khong tim duoc ket qua trong mot so truong hop
		HillClimbing climbing = new HillClimbing();
		System.out.println("Hill Climbing " + time(climbing, model));
	}
}
