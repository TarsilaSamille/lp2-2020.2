package aluno20190046339.rem;

import aluno20190046339.TreeV2;

public class TreeV3 extends Tree {

	public static void main(String[] args) {
		//		Tree tree2 = new Tree();
		//		tree2.insert(12);
		//		tree2.insert(10);
		//		tree2.insert(11);
		//		tree2.insert(15);
		//		tree2.insert(13);
		//		tree2.insert(14);
		//		tree2.insert(16);
		//		tree2.insert(8);
		//		tree2.insert(7);
		//		tree2.insert(9);
		//		tree2.insert(5);
		//		tree2.insert(4);
		//		tree2.insert(3);
		//		tree2.insert(2);
		//		tree2.insert(1);
		//		tree2.insert(24);
		//		tree2.insert(23);
		//		tree2.insert(22);
		//		tree2.insert(21);
		//		System.out.println(tree2);
		//		System.out.println("---------------");
		TreeV3 tree = new TreeV3();
		tree.root = tree.insert(tree.root, 12);
		tree.root = tree.insert(tree.root, 12);
		tree.root = tree.insert(tree.root, 10);
		tree.root = tree.insert(tree.root, 11);
		tree.root = tree.insert(tree.root, 15);
		tree.root = tree.insert(tree.root, 13);
		tree.root = tree.insert(tree.root, 14);
		tree.root = tree.insert(tree.root, 16);
		tree.root = tree.insert(tree.root, 8);
		tree.root = tree.insert(tree.root, 7);
		tree.root = tree.insert(tree.root, 9);
		tree.root = tree.insert(tree.root, 5);
		tree.root = tree.insert(tree.root, 4);
		tree.root = tree.insert(tree.root, 3);
		tree.root = tree.insert(tree.root, 2);
		tree.root = tree.insert(tree.root, 1);
		tree.root = tree.insert(tree.root, 24);
		tree.root = tree.insert(tree.root, 23);
		tree.root = tree.insert(tree.root, 22);
		tree.root = tree.insert(tree.root, 21);

		System.out.println(tree);
		System.out.println("---------------");;
		System.out.println(tree.remove(tree.root, 23));
		System.out.println(tree.remove(tree.root, 24));
		System.out.println(tree.remove(tree.root, 13));
		System.out.println(tree.remove(tree.root, 21));
		System.out.println(tree.remove(tree.root, 15));
		System.out.println("---------------");;

		System.out.println(tree);

	}

	private Node insert(Node node, int value) {
		if (node == null) {
			return new Node(value);
		} else {
			if (value == node.value) return null;
			if (value > node.value) {
				if (node.hasRight()) {
					node.right = insert(node.right, value);
				} else {
					node.right = new Node(value);
					node.right.parent = node;
				}
				return node;
			} else {
				if (node.hasLeft()) {
					node.left = insert(node.left, value);
				} else {
					node.left = new Node(value);
					node.left.parent = node;
				}
				return node;
			}
		}
	}
	private boolean remove(Node node, int value) {
		if (null == node) return false;
		if (value < node.value) {
			remove(node.left, value);
		} else if (value > node.value) {
			remove(node.right, value);
		} else {
			if (node.isLeaf()) {
				if (node.parent.left == node) {
					node.parent.left = null;
				} else node.parent.right = null;
				if( node.parent.hasParent()) node.parent = node.parent.parent;
			} else if (node.hasRight() && !node.hasLeft()) {
				if (node.parent.left == node) {
					node.parent.left = node.right;
				} else node.parent.right = node.right;
				if( node.right.hasParent()) node.right.parent = node.parent;
			} else if (!node.hasRight() && node.hasLeft()) {
				if (node.parent.left == node) {
					node.parent.left = node.left;
				} else node.parent.right = node.left;
				if( node.left.hasParent()) node.left.parent = node.parent;
			} else {
				int valuez = minimoValor(node.right);
				remove(node, valuez);
				node.value =  valuez;
			}
		}
		return true;
	}

	int minimoValor(Node node) {
		if (node.left == null)
			return node.value;
		return minimoValor(node.left);
	}

}