package lab_7;

public class Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		GA_NQueenAlgo algo = new GA_NQueenAlgo();
		algo.initPopulation();
		int count = 0;
		for (int i = 0; i < 100000; i++) {
			Node node = algo.execute();
			if(node.getH() == 0) {
				++count;
			}
			algo.initPopulation();
		}
		System.out.println("So lan thanh cong: " + count);
//		Node node = algo.execute();
//		node.displayBoard();
//		System.out.println("H: " + node.getH());
	}

}
