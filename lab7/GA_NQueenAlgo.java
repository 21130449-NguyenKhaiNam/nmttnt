package lab_7;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class GA_NQueenAlgo {
	public static final int POP_SIZE = 100;// Population size
	public static final double MUTATION_RATE = 0.03;
	public static final int MAX_ITERATIONS = 1200;
	List<Node> population = new ArrayList<Node>();
	Random rd = new Random();

	// initialize the individuals of the population
	public void initPopulation() {
		for (int i = 0; i < POP_SIZE; i++) {
			Node ni = new Node();
			ni.generateBoard();
			population.add(ni);
		}
	}

	public Node execute() {
		// Enter your code here
		for (int j = 0; j < MAX_ITERATIONS; j++) {
			System.out.println("J: " + j);
			List<Node> newPopulation = new ArrayList<Node>();
			for (int i = 0; i < POP_SIZE; i++) {
				Node x = getParentByTournamentSelection();
				Node y = getParentByTournamentSelection();
				Node child = reproduce(x, y);
				if (child.getH() == 0) {
					return child;
				} else if (MUTATION_RATE <= rd.nextDouble()) {
					mutate(child);
				}
				newPopulation.add(child);
			}
			population = newPopulation;

		}
		Collections.sort(population);
		return population.get(0);
	}

	// Mutate an individual by selecting a random Queen and
	// move it to a random row.
	public void mutate(Node node) {
		// Enter your code here
		node.getState()[rd.nextInt(node.getState().length)].setRow(rd.nextInt(Node.N));
	}

	// Crossover x and y to reproduce a child
	public Node reproduce(Node x, Node y) {
		// Enter your code here
		Node node = new Node();
		int n = rd.nextInt(1, Node.N - 1);
		for (int i = 0; i < Node.N; i++)
			node.setRow(i, i < n ? x.getRow(i) : y.getRow(i));
		return node;
	}

	// Select K individuals from the population at random and
	// select the best out of these to become a parent.
	public Node getParentByTournamentSelection() {
		// Enter your code here
		int k = 10;
		Node node = population.get(rd.nextInt(population.size()));
		for (int i = 1; i < k; i++) {
			Node tmp = population.get(rd.nextInt(population.size()));
			if (tmp.getH() < node.getH())
				node = tmp;
		}
		return node;
	}

	// Select a random parent from the population
	public Node getParentByRandomSelection() {
		// Enter your code here
		return population.get(rd.nextInt(POP_SIZE));
	}

}
