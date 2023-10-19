package lab4.inform.student;

public interface IInformedSearchAlgo {
	public Node execute(Node root, String goal);

	public Node execute(Node root, String start, String goal);

	public Node executeTree(Node root, String goal);

	public Node executeTree(Node root, String start, String goal);

}
