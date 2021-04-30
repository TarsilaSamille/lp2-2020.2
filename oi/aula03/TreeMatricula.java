package aula03;

public class TreeMatricula {

	public static void main(String[] args) {
			Tree root = new Tree(2);
			Tree n4 = new Tree(0);
			Tree n10 = new Tree(6);
			Tree n8 = new Tree(4);
			Tree n11 = new Tree(7);
			Tree n2 = new Tree(0);
			Tree n5 = new Tree(1);
			Tree n1 = new Tree(2);
			Tree n3 = new Tree(2);
			Tree n7 = new Tree(3);
			Tree n9 = new Tree(5);


			root.setChilds(n4, n10);
			n4.setChilds(n2, n5);
			n2.setChilds(n1, n3);
			n10.setChilds(n8, n11);
			n8.setChilds(n7, n9);


			TreeMatricula tree_a = new TreeMatricula(root);
//			tree_a.inOrder();
//		System.out.print("\n");
//
//		tree_a.preOrder();
//		System.out.print("\n");
//
//		tree_a.posOrder();
//		System.out.print("\n");
//
		tree_a.preeOrder();
		//System.out.print(root);


	}

		private Tree root;

		public TreeMatricula(Tree root) {
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

	public void preeOrder() {
		preeOrder(root);
	}

	private void preeOrder(Tree root) {
		if (root != null) {
			preeOrder(root.right);
			System.out.print(root);
			preeOrder(root.left);
		}
	}
	}
