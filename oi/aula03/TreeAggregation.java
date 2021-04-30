package aula03;

public class TreeAggregation {
	
	public static void main(String[] args) {
		Tree root = new Tree(1);
		Tree left = new Tree(2);
		Tree right = new Tree(3);
		root.setChilds(left, right);
		TreeAggregation tree_a = new TreeAggregation(root);
		tree_a.inOrder();
		System.out.print("\n");

		TreeAggregation tree_b = new TreeAggregation(root);
		tree_b.inOrder();
		tree_a.root.left = null;
		tree_b.inOrder();
	}
	
	private Tree root;

	public TreeAggregation(Tree root) {
		this.root = root;
	}

	public void preOrder() {
		preOrder(root);
	}

	private void preOrder(Tree root) {
		if (root != null) {
			System.out.print(root);
			preOrder(root.left);
			preOrder(root.right);
		}
	}

	public void inOrder() {
		inOrder(root);
	}

	private void inOrder(Tree root) {
		if (root != null) {
			inOrder(root.left);
			System.out.print(root);
			inOrder(root.right);
		}
	}

	public void posOrder() {
		posOrder(root);
	}

	private void posOrder(Tree root) {
		if (root != null) {
			posOrder(root.left);
			posOrder(root.right);
			System.out.print(root);
		}
	}
}
