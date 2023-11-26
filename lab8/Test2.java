package game_alphabeta_student;

public class Test2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Node A = new Node("A");
		
		Node B = new Node("B");
		Node C = new Node("C");
		Node D = new Node("D", 0);
		Node E = new Node("E");
		A.addChild(B);
		A.addChild(C);
		A.addChild(D);
		A.addChild(E);
		
		Node F = new Node("F");
		Node G = new Node("G", -5);
		B.addChild(F);
		B.addChild(G);
		
		Node H = new Node("H", 3);
		Node I = new Node("I", 8);
		Node J = new Node("J");
		C.addChild(H);
		C.addChild(I);
		C.addChild(J);
		
		Node K = new Node("K");
		Node L = new Node("L", 2);
		Node M = new Node("M");
		E.addChild(K);
		E.addChild(L);
		E.addChild(M);
		
		Node N = new Node("N", 4);
		Node O = new Node("O");
		F.addChild(N);
		F.addChild(O);
		
		Node P = new Node("P", 9);
		Node Q = new Node("Q", -6);
		Node R = new Node("R", 0);
		J.addChild(P);
		J.addChild(Q);
		J.addChild(R);
		
		Node S = new Node("S", 3);
		Node T = new Node("T", 5);
		K.addChild(S);
		K.addChild(T);
		
		Node U = new Node("U", -7);
		Node V = new Node("V", -9);
		M.addChild(U);
		M.addChild(V);
		
		Node W = new Node("W", -3);
		Node X = new Node("X", -5);
		O.addChild(W);
		O.addChild(X);
		
//		AlphaBetaSearchAlgo asa = new AlphaBetaSearchAlgo();
//		asa.execute(A);
//		A.print();
		
		AlphaBetaRightToLeftSearchAlgo abtsa = new AlphaBetaRightToLeftSearchAlgo();
		abtsa.execute(A);
		A.print();
	}

}
