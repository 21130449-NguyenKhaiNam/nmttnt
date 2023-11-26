package game_alphabeta_student;

public class Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Node A = new Node("A");
		
		Node B = new Node("B");
		Node C = new Node("C");
		Node D = new Node("D");
		A.addChild(B);
		A.addChild(C);
		A.addChild(D);
		
		Node E = new Node("E", 3);
		Node F = new Node("F", 12);
		Node G = new Node("G", 8);
		B.addChild(E);
		B.addChild(F);
		B.addChild(G);
		
		Node H = new Node("H", 2);
		Node I = new Node("I", 4);
		Node J = new Node("J", 6);
		C.addChild(H);
		C.addChild(I);
		C.addChild(J);
		
		Node K = new Node("K", 14);
		Node L = new Node("L", 5);
		Node M = new Node("M", 2);
		D.addChild(K);
		D.addChild(L);
		D.addChild(M);
		
		MiniMaxSearchAlgo msa = new MiniMaxSearchAlgo();
		msa.execute(A);
		A.print();
	}

}
