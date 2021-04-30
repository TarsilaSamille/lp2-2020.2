package aula03;

public class TreeComposition {

	public static void main(String[] args) {
		TreeComposition tree = new TreeComposition(1, 2, 3);
		tree.preOrder();
	}

	private Node root;

	public TreeComposition(int a, int b, int c) {
		root = new Node(a);
		Node node1 = new Node(b);
		Node node2 = new Node(c);
		root.setChilds(node1, node2);
	}

	public void preOrder() {
		preOrder(root);
	}

	private void preOrder(Node root) {
		if (root != null) {
			System.out.print(root);
			preOrder(root.left);
			preOrder(root.right);
		}
	}

	public void inOrder() {
		inOrder(root);
	}

	private void inOrder(Node root) {
		if (root != null) {
			inOrder(root.left);
			System.out.print(root);
			inOrder(root.right);
		}
	}

	public void posOrder() {
		posOrder(root);
	}

	private void posOrder(Node root) {
		if (root != null) {
			posOrder(root.left);
			posOrder(root.right);
			System.out.print(root);
		}
	}
}
