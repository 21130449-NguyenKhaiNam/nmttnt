package game_nim_student;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Node {
	private int num = 0;
	private List<Integer> data = new ArrayList<Integer>();
	private List<Node> children = new ArrayList<Node>();

	public void add(Integer val) {
		this.data.add(val);
	}

	/**
	 * @param num the num to set
	 */
	public void setNum(int num) {
		this.num = num;
	}

	/**
	 * @return the num
	 */
	public int getNum() {
		return num;
	}

	public void addAll(List<Integer> data) {
		this.data.addAll(data);
	}

	/**
	 * @return the children
	 */
	public List<Node> getChildren() {
		return children;
	}

	// Get children of the current nodes
	public List<Node> getSuccessors() {
		// Enter your code here
		Set<List<Integer>> set = new HashSet<>();
		List<Node> nodes = new ArrayList<Node>();
		for (int i = 0; i < data.size(); i++) {
			int d = data.get(i);
			if (d > 2) {
				int devide = d / 2;
				for (int j = 1; j <= devide; j++) {
					int minus = d - j;
					if (minus != devide) {
						List<Integer> dataChild = new ArrayList<Integer>();
						dataChild.addAll(data);
						dataChild.remove(i);
						dataChild.add(minus);
						dataChild.add(j);
						if (!set.contains(dataChild)) {
							Node node = new Node();
							node.addAll(dataChild);
							nodes.add(node);
							children.add(node);
							set.add(dataChild);
						}
					} else {
						break;
					}
				}
			} else {
				break;
			}
		}
		return nodes;
	}

	// Check whether a node is terminal or not
	public boolean isTerminal() {
		// Enter your code here
		Collections.sort(this.data, DESCOMPARATOR);
		return data.get(0) < 3;
	}

	/**
	 * @return the data
	 */
	public List<Integer> getData() {
		return data;
	}

	public static final Comparator<Integer> DESCOMPARATOR = new Comparator<Integer>() {

		@Override
		public int compare(Integer o1, Integer o2) {
			return o2.compareTo(o1);
		}
	};

	@Override
	public String toString() {
		Collections.sort(this.data, DESCOMPARATOR);
		return this.data.toString();
	}

}
