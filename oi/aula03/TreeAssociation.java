package aula03;

public class TreeAssociation {

	public static void main(String[] args) {
		NodeAssociation root = new NodeAssociation(1);
		NodeAssociation left = new NodeAssociation(2);
		NodeAssociation right = new NodeAssociation(3);
		root.setChilds(left, right);
		TreeAssociation tree = new TreeAssociation(root);
		tree.inOrder();
	}

	private NodeAssociation root;

	public TreeAssociation(NodeAssociation root) {
		this.root = root;
		this.root.tree = this;
	}

	public void preOrder() {
		preOrder(root);
	}

	private void preOrder(NodeAssociation root) {
		if (root != null) {
			System.out.print(root);
			preOrder(root.left);
			preOrder(root.right);
		}
	}

	public void inOrder() {
		inOrder(root);
	}

	private void inOrder(NodeAssociation root) {
		if (root != null) {
			inOrder(root.left);
			System.out.print(root);
			inOrder(root.right);
		}
	}

	public void posOrder() {
		posOrder(root);
	}

	private void posOrder(NodeAssociation root) {
		if (root != null) {
			posOrder(root.left);
			posOrder(root.right);
			System.out.print(root);
		}
	}
}
