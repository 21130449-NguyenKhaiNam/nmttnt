package student;

public class SA {
	public static Node execute(Node initialState) {
		double t = 100;
		Node curr = initialState;
		while(curr.getH() != 0) {
			if(t <= 0)
				return curr;
			Node next = curr.selectNextRandomCandidate();
			double e = curr.getH() - next.getH();
			if(e > 0 || Math.pow(Math.E, e / t) < Math.random()) {
				curr = next;
			}
			t *= 0.99;
		}
		return curr;
	}
}
