package game_nim_student;

public class Node2 {
	private Node2 parent;
	private Node node;

	/**
	 * @param parent
	 * @param node
	 */
	public Node2(Node2 parent, Node node) {
		super();
		this.parent = parent;
		this.node = node;
	}

	/**
	 * @return the parent
	 */
	public Node2 getParent() {
		return parent;
	}

	/**
	 * @return the node
	 */
	public Node getNode() {
		return node;
	}

	@Override
	public String toString() {
		return "parent=" + parent + ", node=" + node + " | ";
	}

}
