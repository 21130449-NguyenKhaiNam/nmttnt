package student;

public class HillClimbing {
	public static Node execute(Node initialState) {
		// Enter your code here.
		Node tmp = new Node(initialState);
		int h = tmp.getH();
		if(h == 0) {
			return tmp;
		}
		while(tmp.getH() != 0) {
			boolean flag = false;
			for (Node child : tmp.generateAllCandidates()) {
				if(child.getH() < tmp.getH()) {
					flag = true;
					tmp = child;
				}
			}
			if(!flag) {
				break;
			}
		}
		return tmp;
	}
	
	static int stepClimbed = 0;
	static int stepClimbedAfterRandomRestart = 0;
	static int randomRestarts = 0;

	public static Node executeHillClimbingWithRandomRestart(Node initialState) {
		// Enter your code here.
		Node tmp = new Node(initialState);
		int h = tmp.getH();
		if(h == 0) {
			return tmp;
		}
		while(tmp.getH() != 0) {
			boolean flag = false;
			for (Node child : tmp.generateAllCandidates()) {
				if(child.getH() < tmp.getH()) {
					flag = true;
					tmp = child;
					++stepClimbed;
					++stepClimbedAfterRandomRestart;
				}
			}
			if(!flag) {
				++randomRestarts;
				stepClimbedAfterRandomRestart = 0;
				tmp.generateBoard();
			}
		}
		System.out.println("stepClimbed: " + stepClimbed);
		System.out.println("stepClimbedAfterRandomRestart: " + stepClimbedAfterRandomRestart);
		System.out.println("randomRestarts: " + randomRestarts);
		return tmp;
	}

}
