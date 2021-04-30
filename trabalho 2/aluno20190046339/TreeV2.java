package aluno20190046339;

public class TreeV2 extends Tree {

	public static void main(String [] args) {
		Tree tree2 = new Tree();
		tree2.insert(12);
		tree2.insert(10);
		tree2.insert(11);
		tree2.insert(15);
		tree2.insert(13);
		tree2.insert(14);
		tree2.insert(16);
		tree2.insert(8);
		tree2.insert(7);
		tree2.insert(9);
		tree2.insert(5);
		tree2.insert(4);
		tree2.insert(3);
		tree2.insert(2);
		tree2.insert(1);
		tree2.insert(24);
		tree2.insert(23);
		tree2.insert(22);
		tree2.insert(21);
		System.out.println(tree2);
		System.out.println("---------------");

		TreeV2 tree = new TreeV2();
		tree.root = tree.insert(tree.root,12);
		tree.root = tree.insert(tree.root,12);
		tree.root = tree.insert(tree.root,10);
		tree.root = tree.insert(tree.root,11);
		tree.root = tree.insert(tree.root,15);
		tree.root = tree.insert(tree.root,13);
		tree.root = tree.insert(tree.root,14);
		tree.root = tree.insert(tree.root,16);
		tree.root = tree.insert(tree.root,8);
		tree.root = tree.insert(tree.root,7);
		tree.root = tree.insert(tree.root,9);
		tree.root = tree.insert(tree.root,5);
		tree.root = tree.insert(tree.root,4);
		tree.root = tree.insert(tree.root,3);
		tree.root = tree.insert(tree.root,2);
		tree.root = tree.insert(tree.root,1);
		tree.root = tree.insert(tree.root,24);
		tree.root = tree.insert(tree.root,23);
		tree.root = tree.insert(tree.root,22);
		tree.root = tree.insert(tree.root,21);

		System.out.println(tree);
		System.out.println("---------------");

		System.out.println(tree2.equals(tree));
		System.out.println(tree.equals(tree2));


	}

	private Node insert(Node node, int value) {
		if(node == null) {
			return new Node(value);
		} else {
			if(value==node.value) return null;
			if(value > node.value) {
				if(node.hasRight()) {
					node.right = insert(node.right, value);
				} else {
					node.right = new Node(value);
				}
				return node;
			} else {
				if(node.hasLeft()) {
					node.left = insert(node.left, value);
				} else {
					node.left = new Node(value);
				}
				return node;
			}
		}
	}

}
